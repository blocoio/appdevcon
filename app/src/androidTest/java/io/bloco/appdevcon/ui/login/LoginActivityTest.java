package io.bloco.appdevcon.ui.login;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

  @Rule
  public ActivityTestRule<LoginActivity> activityTestRule =
      new ActivityTestRule<>(LoginActivity.class);

  @Test
  public void nameMissing() throws Exception {
    // TODO
  }

  @Test
  public void nameTooShort() throws Exception {
    // TODO
  }

  @Test
  public void loginSuccessful() throws Exception {
    // TODO
  }
}
