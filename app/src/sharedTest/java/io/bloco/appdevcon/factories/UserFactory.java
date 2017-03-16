package io.bloco.appdevcon.factories;

import io.bloco.appdevcon.data.model.User;

public class UserFactory extends BaseFactory<User> {

  @Override public User build() {
    User user = new User();
    user.setName(faker.internet.userName());
    return user;
  }
}
