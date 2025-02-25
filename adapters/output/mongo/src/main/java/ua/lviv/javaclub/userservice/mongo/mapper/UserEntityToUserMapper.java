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
  public User apply(@NonNull final MongoUserEntity userEntity) {
    return User.builder()
        .id(userEntity.getId())
        .name(userEntity.getName())
        .email(userEntity.getEmail())
        .status(userEntity.getStatus())
        .createdAt(userEntity.getCreatedAt())
        .build();
  }
}
