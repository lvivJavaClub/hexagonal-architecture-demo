package ua.lviv.javaclub.userservice.kafka;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.lviv.javaclub.userservice.application.ports.input.CreateUserUseCase;
import ua.lviv.javaclub.userservice.kafka.dto.UserDto;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.join;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaUserListener {

  private final CreateUserUseCase createUserUseCase;

  @KafkaListener(topics = "${spring.kafka.topics.user-topic}",
      groupId = "${spring.kafka.consumer.group-id}")
  public void listen(@NonNull final UserDto userDto) {
//  public void listen(@NonNull String message) {
//    final String name = join(" ", userDto.getFirstName(), userDto.getMiddleName(), userDto.getLastName());
//    createUserUseCase.createUser(name, userDto.getEmail());
//    log.error("{}", message);
    log.error("{}", userDto);
  }
}
