package ua.lviv.javaclub.userservice.postgresql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ua.lviv.javaclub.userservice.model.user.UserStatus;

import java.time.OffsetDateTime;

@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "user_seq", sequenceName = "users_seq", allocationSize = 1)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  private Long id;
  private String name;
  private String email;
  @Enumerated(EnumType.STRING)
  private UserStatus status;
  private OffsetDateTime createdAt;
}
