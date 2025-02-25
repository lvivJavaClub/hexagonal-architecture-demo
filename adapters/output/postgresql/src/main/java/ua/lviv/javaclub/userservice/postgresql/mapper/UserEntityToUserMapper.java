package ua.lviv.javaclub.userservice.postgresql.mapper;

import ua.lviv.javaclub.userservice.model.user.User;
import ua.lviv.javaclub.userservice.postgresql.entity.UserEntity;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserEntityToUserMapper implements Function<UserEntity, User> {

  @NonNull
  @Override
  public User apply(@NonNull final UserEntity userEntity) {
    return User.builder()
        .id(userEntity.getId())
        .name(userEntity.getName())
        .email(userEntity.getEmail())
        .status(userEntity.getStatus())
        .createdAt(userEntity.getCreatedAt())
        .build();
  }
}
