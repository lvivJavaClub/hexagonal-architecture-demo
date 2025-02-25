package ua.lviv.javaclub.userservice.rest.dto;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class UserRequestDto {
  @JsonProperty("user-name")
  private String name;
  @JsonProperty("user-email")
  private String email;
}
