package io.bloco.appdevcon.testing;

import android.support.test.InstrumentationRegistry;
import io.bloco.appdevcon.AndroidApplication;
import io.bloco.appdevcon.common.di.ApplicationComponent;
import io.bloco.appdevcon.data.model.User;

public class TestStateManager {

  private final ApplicationComponent applicationComponent;

  public TestStateManager() {
    applicationComponent = ((AndroidApplication) InstrumentationRegistry.getTargetContext()
        .getApplicationContext()).getApplicationComponent();
  }

  public User login() {
    // TODO
    throw new UnsupportedOperationException();
  }

  public void logout() {
    // TODO
    throw new UnsupportedOperationException();
  }
}
