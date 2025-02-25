package ua.lviv.javaclub.userservice.application.ports.output;

import ua.lviv.javaclub.userservice.model.user.User;

import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserOutputPort {

  @NonNull
  User saveUser(@NonNull final User user);

  @NonNull
  Optional<User> findById(@NonNull final Long id);

  @NonNull
  Optional<User> findByEmail(@NonNull final String email);
}
