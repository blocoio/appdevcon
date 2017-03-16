package io.bloco.appdevcon.data;

import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import io.bloco.appdevcon.AndroidApplication;
import io.bloco.appdevcon.common.di.ApplicationComponent;
import io.bloco.appdevcon.data.model.User;
import io.bloco.appdevcon.factories.UserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class UserRepositoryTest {

  private UserRepository userRepository;
  private SharedPreferences sharedPreferences;

  @Before
  public void setUp() throws Exception {
    ApplicationComponent applicationComponent =
        ((AndroidApplication) InstrumentationRegistry.getTargetContext()
            .getApplicationContext()).getApplicationComponent();

    sharedPreferences = applicationComponent.sharePreferences();
    userRepository =
        new UserRepository(sharedPreferences, applicationComponent.gson());
  }

  @After
  public void tearDown() throws Exception {
    sharedPreferences.edit().clear().apply();
  }

  @Test
  public void setAndGet() throws Exception {
    assertThat(userRepository.get(), is(equalTo(null)));
    User user = new UserFactory().build();
    userRepository.set(user);
    assertThat(userRepository.get(), is(equalTo(user)));
  }
}