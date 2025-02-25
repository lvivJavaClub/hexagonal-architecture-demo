package ua.lviv.javaclub.userservice.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Long id;
  private String name;
  private String email;
  @Builder.Default
  private UserStatus status = UserStatus.INACTIVE;
  @Builder.Default
  private OffsetDateTime createdAt = OffsetDateTime.now();
}
