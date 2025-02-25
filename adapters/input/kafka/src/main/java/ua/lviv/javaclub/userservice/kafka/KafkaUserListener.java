package ua.lviv.javaclub.userservice.kafka;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ua.lviv.javaclub.userservice.application.ports.input.CreateUserUseCase;
import ua.lviv.javaclub.userservice.kafka.dto.UserDto;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static java.lang.String.join;

@Component
@RequiredArgsConstructor
public class KafkaUserListener {

  private final CreateUserUseCase createUserUseCase;

  @KafkaListener
  public void listen(@NonNull final UserDto userDto) {
    final String name = join(" ", userDto.getFirstName(), userDto.getMiddleName(), userDto.getLastName());
    createUserUseCase.createUser(name , userDto.getEmail());
  }
}
