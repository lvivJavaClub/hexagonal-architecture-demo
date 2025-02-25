package ua.lviv.javaclub.userservice.postgresql;

import lombok.RequiredArgsConstructor;
import ua.lviv.javaclub.userservice.application.ports.output.UserOutputPort;
import ua.lviv.javaclub.userservice.model.user.User;
import ua.lviv.javaclub.userservice.postgresql.entity.UserEntity;
import ua.lviv.javaclub.userservice.postgresql.mapper.UserEntityToUserMapper;
import ua.lviv.javaclub.userservice.postgresql.mapper.UserToUserEntityMapper;
import ua.lviv.javaclub.userservice.postgresql.repository.UserRepository;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPostgresqlRepository implements UserOutputPort {
  private final UserToUserEntityMapper userToUserEntityMapper;
  private final UserEntityToUserMapper userEntityToUserMapper;
  
  private final UserRepository userRepository;

  @NonNull
  @Override
  public User saveUser(@NonNull final User user) {
    final UserEntity entity = userToUserEntityMapper.apply(user);
    final UserEntity save = userRepository.save(entity);
    return userEntityToUserMapper.apply(save);
  }

  @NonNull
  @Override
  public Optional<User> findById(@NonNull final Long id) {
    return userRepository.findById(id)
        .map(userEntityToUserMapper);
  }

  @NonNull
  @Override
  public Optional<User> findByEmail(@NonNull final String email) {
    return userRepository.findByEmail(email)
        .map(userEntityToUserMapper);
  }
}
