package ua.lviv.javaclub.userservice.postgresql.repository;


import ua.lviv.javaclub.userservice.postgresql.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  @NonNull
  Optional<UserEntity> findByEmail(@NonNull final String email);
}
