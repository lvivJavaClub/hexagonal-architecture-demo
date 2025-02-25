package ua.lviv.javaclub.userservice.postgresql.mapper;

import ua.lviv.javaclub.userservice.model.user.User;
import ua.lviv.javaclub.userservice.postgresql.entity.UserEntity;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserToUserEntityMapper implements Function<User, UserEntity> {

  @NonNull
  @Override
  public UserEntity apply(@NonNull final User user) {
    return UserEntity.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .status(user.getStatus())
        .createdAt(user.getCreatedAt())
        .build();
  }
}
