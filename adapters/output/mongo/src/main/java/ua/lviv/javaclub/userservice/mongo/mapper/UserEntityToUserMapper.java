package ua.lviv.javaclub.userservice.mongo.mapper;

import ua.lviv.javaclub.userservice.model.user.User;
import ua.lviv.javaclub.userservice.mongo.entity.MongoUserEntity;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserEntityToUserMapper implements Function<MongoUserEntity, User> {

  @NonNull
  @Override
  public User apply(@NonNull final MongoUserEntity mongoUserEntity) {
    return User.builder()
        .id(mongoUserEntity.getId())
        .name(mongoUserEntity.getName())
        .email(mongoUserEntity.getEmail())
        .status(mongoUserEntity.getStatus())
        .createdAt(mongoUserEntity.getCreatedAt())
        .build();
  }
}
