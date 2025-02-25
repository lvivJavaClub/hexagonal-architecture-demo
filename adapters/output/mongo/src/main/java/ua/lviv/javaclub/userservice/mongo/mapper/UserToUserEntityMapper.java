package ua.lviv.javaclub.userservice.mongo.mapper;

import ua.lviv.javaclub.userservice.model.user.User;
import ua.lviv.javaclub.userservice.mongo.entity.MongoUserEntity;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserToUserEntityMapper implements Function<User, MongoUserEntity> {

  @NonNull
  @Override
  public MongoUserEntity apply(@NonNull final User user) {
    return MongoUserEntity.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .status(user.getStatus())
        .createdAt(user.getCreatedAt())
        .build();
  }
}
