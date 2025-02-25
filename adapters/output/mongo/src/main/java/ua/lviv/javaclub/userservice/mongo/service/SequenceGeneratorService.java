package ua.lviv.javaclub.userservice.mongo.service;

import lombok.RequiredArgsConstructor;
import ua.lviv.javaclub.userservice.mongo.entity.Counter;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SequenceGeneratorService {
  private final MongoOperations mongoOperations;

  public Long generateSequence(String seqName) {
    Counter counter = mongoOperations.findAndModify(
        Query.query(Criteria.where("_id").is(seqName)),
        new Update().inc("seq", 1),
        FindAndModifyOptions.options().returnNew(true).upsert(true),
        Counter.class
    );
    return counter != null ? counter.getSeq() : 1L;
  }
}
