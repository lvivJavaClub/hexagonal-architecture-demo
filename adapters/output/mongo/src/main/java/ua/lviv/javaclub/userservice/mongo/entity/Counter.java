package ua.lviv.javaclub.userservice.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Counter {
  @Id
  private String id;
  private long seq;
}
