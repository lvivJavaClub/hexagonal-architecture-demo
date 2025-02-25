package ua.lviv.javaclub.userservice.rest.dto;

import lombok.Builder;
import lombok.Data;
import ua.lviv.javaclub.userservice.model.user.UserStatus;

import java.time.OffsetDateTime;

@Data
@Builder
public class UserResponseDto {
  private Long id;
  private String name;
  private UserStatus status;
  private OffsetDateTime createdAt;
}
