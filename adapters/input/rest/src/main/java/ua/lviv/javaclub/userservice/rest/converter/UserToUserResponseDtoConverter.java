package ua.lviv.javaclub.userservice.rest.converter;

import lombok.NonNull;
import ua.lviv.javaclub.userservice.model.user.User;
import ua.lviv.javaclub.userservice.rest.dto.UserResponseDto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResponseDtoConverter implements Converter<User, UserResponseDto> {

  @NonNull
  @Override
  public UserResponseDto convert(@NonNull final User user) {
    return UserResponseDto.builder()
        .id(user.getId())
        .name(user.getName())
        .status(user.getStatus())
        .createdAt(user.getCreatedAt())
        .build();
  }
}
