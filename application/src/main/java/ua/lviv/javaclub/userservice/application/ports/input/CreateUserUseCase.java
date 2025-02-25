package ua.lviv.javaclub.userservice.application.ports.input;

import ua.lviv.javaclub.userservice.model.user.User;

import org.springframework.lang.NonNull;

public interface CreateUserUseCase {
  @NonNull
  User createUser(@NonNull final String name, @NonNull final String email);
}
