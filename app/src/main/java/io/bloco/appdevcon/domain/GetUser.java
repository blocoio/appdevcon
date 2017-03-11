package io.bloco.appdevcon.domain;

import io.bloco.appdevcon.data.UserRepository;
import io.bloco.appdevcon.data.model.User;
import javax.inject.Inject;

public class GetUser {

  private final UserRepository userRepository;

  @Inject public GetUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User get() {
    return userRepository.get();
  }
}
