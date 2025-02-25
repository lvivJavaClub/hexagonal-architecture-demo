package ua.lviv.javaclub.userservice.application.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(Long id) {
    super("No user with ID: " + id + " does not exist");
  }
}
