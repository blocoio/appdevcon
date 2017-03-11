package io.bloco.appdevcon;

import android.app.Application;
import io.bloco.appdevcon.common.di.ApplicationComponent;
import io.bloco.appdevcon.common.di.ApplicationModule;
import io.bloco.appdevcon.common.di.DaggerApplicationComponent;
import timber.log.Timber;

import static io.bloco.appdevcon.AndroidApplication.Mode.TEST;

public class AndroidApplication extends Application {

  private ApplicationComponent applicationComponent;
  private Mode mode;

  @Override public void onCreate() {
    super.onCreate();
    checkTestMode();
    this.initializeInjector();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }

  public Mode getMode() {
    return mode;
  }

  private void initializeInjector() {
    this.applicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();
  }

  // Test loading a random test class, to check if we're in test mode
  private void checkTestMode() {
    try {
      getClassLoader().loadClass("io.bloco.appdevcon.AndroidApplicationTest");
      mode = TEST;
    } catch (final Exception e) {
      mode = Mode.NORMAL;
    }
  }

  public enum Mode {
    NORMAL, TEST
  }
}