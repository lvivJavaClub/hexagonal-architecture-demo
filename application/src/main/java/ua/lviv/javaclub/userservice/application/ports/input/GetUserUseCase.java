package ua.lviv.javaclub.userservice.application.ports.input;

import ua.lviv.javaclub.userservice.model.user.User;

import org.springframework.lang.NonNull;

public interface GetUserUseCase {
  @NonNull
  User findById(@NonNull final Long id);
}
