package ua.lviv.javaclub.userservice.mongo;

import lombok.RequiredArgsConstructor;
import ua.lviv.javaclub.userservice.application.ports.output.UserOutputPort;
import ua.lviv.javaclub.userservice.model.user.User;
import ua.lviv.javaclub.userservice.mongo.entity.MongoUserEntity;
import ua.lviv.javaclub.userservice.mongo.mapper.UserEntityToUserMapper;
import ua.lviv.javaclub.userservice.mongo.mapper.UserToUserEntityMapper;
import ua.lviv.javaclub.userservice.mongo.repository.UserRepository;
import ua.lviv.javaclub.userservice.mongo.service.SequenceGeneratorService;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserMongoRepository implements UserOutputPort {
  private final UserToUserEntityMapper userToUserEntityMapper;
  private final UserEntityToUserMapper userEntityToUserMapper;
  private final SequenceGeneratorService sequenceGeneratorService;
  
  private final UserRepository userRepository;

  @NonNull
  @Override
  public User saveUser(@NonNull final User user) {
    final MongoUserEntity entity = userToUserEntityMapper.apply(user);
    if (user.getId() == null) {  // Generate ID only if not provided
      entity.setId(sequenceGeneratorService.generateSequence("user_sequence"));
    }
    final MongoUserEntity save = userRepository.save(entity);
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
