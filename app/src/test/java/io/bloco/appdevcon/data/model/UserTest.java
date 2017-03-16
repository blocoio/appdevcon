package io.bloco.appdevcon.data.model;

import io.bloco.appdevcon.factories.UserFactory;
import io.bloco.faker.Faker;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserTest {

  private Faker faker;
  private UserFactory userFactory;

  @Before
  public void setUp() throws Exception {
    faker = new Faker("nl");
    userFactory = new UserFactory();
  }

  @Test
  public void getBestName_withoutRealName() throws Exception {
    User user = userFactory.build();

    assertThat(user.getBestName(), is(equalTo(user.getName())));
  }

  @Test
  public void getBestName_withRealName() throws Exception {
    User user = userFactory.build();
    user.setRealName(faker.name.name());

    assertThat(user.getBestName(), is(equalTo(user.getRealName())));
  }
}