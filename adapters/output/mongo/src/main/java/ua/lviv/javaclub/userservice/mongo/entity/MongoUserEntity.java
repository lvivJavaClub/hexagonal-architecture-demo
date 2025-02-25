package ua.lviv.javaclub.userservice.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.lviv.javaclub.userservice.model.user.UserStatus;

import java.time.OffsetDateTime;

@Document(collection = "APP_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MongoUserEntity {

  @Id
  private Long id;
  private String name;
  private String email;
  private UserStatus status;
  private OffsetDateTime createdAt;
}
