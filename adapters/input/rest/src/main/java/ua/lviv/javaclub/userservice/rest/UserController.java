package ua.lviv.javaclub.userservice.rest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ua.lviv.javaclub.userservice.application.ports.input.CreateUserUseCase;
import ua.lviv.javaclub.userservice.application.ports.input.GetUserUseCase;
import ua.lviv.javaclub.userservice.application.exception.UserAlreadyExistException;
import ua.lviv.javaclub.userservice.application.exception.UserNotFoundException;
import ua.lviv.javaclub.userservice.rest.converter.UserToUserResponseDtoConverter;
import ua.lviv.javaclub.userservice.rest.dto.UserRequestDto;
import ua.lviv.javaclub.userservice.rest.dto.UserResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserToUserResponseDtoConverter userToUserResponseDtoConverter;

  private final CreateUserUseCase createUserUseCase;
  private final GetUserUseCase getUserUseCase;

  @NonNull
  @PostMapping
  public UserResponseDto createUser(@RequestBody final UserRequestDto userRequestDto) {
    return userToUserResponseDtoConverter.convert(
        createUserUseCase.createUser(userRequestDto.getName(), userRequestDto.getEmail()));
  }

  @ExceptionHandler(UserAlreadyExistException.class)
  public ResponseEntity<String> handleUserAlreadyExistException(@NonNull final UserAlreadyExistException exception) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
  }

  @NonNull
  @GetMapping("/{id}")
  public UserResponseDto getUser(@NonNull @PathVariable("id") final Long id) {
    return userToUserResponseDtoConverter.convert(
        getUserUseCase.findById(id));
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<String> handleUserNotFoundException(@NonNull final UserNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}
