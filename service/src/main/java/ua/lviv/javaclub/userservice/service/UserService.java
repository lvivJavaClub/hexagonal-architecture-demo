package ua.lviv.javaclub.userservice.service;

import lombok.RequiredArgsConstructor;
import ua.lviv.javaclub.userservice.application.exception.UserAlreadyExistException;
import ua.lviv.javaclub.userservice.application.exception.UserNotFoundException;
import ua.lviv.javaclub.userservice.application.ports.input.CreateUserUseCase;
import ua.lviv.javaclub.userservice.application.ports.input.GetUserUseCase;
import ua.lviv.javaclub.userservice.application.ports.output.UserOutputPort;
import ua.lviv.javaclub.userservice.model.user.User;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class UserService implements CreateUserUseCase, GetUserUseCase {

  private final UserOutputPort userOutputPort;

  @NonNull
  @Override
  public User createUser(@NonNull final String name, @NonNull final String email) {
    userOutputPort.findByEmail(email)
        .ifPresentOrElse(user -> {throw new UserAlreadyExistException(email);}, () -> {});

    final User user = User.builder()
        .name(name)
        .email(email)
        .createdAt(OffsetDateTime.now())
        .build();
    return userOutputPort.saveUser(user);
  }

  @NonNull
  @Override
  public User findById(@NonNull final Long id) {
    return userOutputPort.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
  }
}
