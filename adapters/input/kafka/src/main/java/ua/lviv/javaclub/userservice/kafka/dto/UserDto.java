package ua.lviv.javaclub.userservice.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
  private String firstName;
  private String middleName;
  private String lastName;
  private String email;
}
