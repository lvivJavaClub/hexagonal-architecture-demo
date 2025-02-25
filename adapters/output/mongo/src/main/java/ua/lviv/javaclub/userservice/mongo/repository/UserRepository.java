package ua.lviv.javaclub.userservice.mongo.repository;



import ua.lviv.javaclub.userservice.mongo.entity.MongoUserEntity;

import org.springframework.lang.NonNull;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<MongoUserEntity, Long> {
  @NonNull
  Optional<MongoUserEntity> findByEmail(@NonNull final String email);
}
