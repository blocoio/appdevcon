package io.bloco.appdevcon.data;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import io.bloco.appdevcon.AndroidApplication;
import io.bloco.appdevcon.common.di.ApplicationComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UserRepositoryTest {

  private UserRepository userRepository;

  @Before
  public void setUp() throws Exception {
    ApplicationComponent applicationComponent =
        ((AndroidApplication) InstrumentationRegistry.getTargetContext()
            .getApplicationContext()).getApplicationComponent();

    userRepository =
        new UserRepository(applicationComponent.sharePreferences(), applicationComponent.gson());
  }

  @Test
  public void setAndGet() throws Exception {
    // TODO
  }
}