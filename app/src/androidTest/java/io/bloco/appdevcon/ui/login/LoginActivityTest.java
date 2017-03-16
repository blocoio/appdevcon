package io.bloco.appdevcon.ui.login;

import android.support.annotation.StringRes;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import io.bloco.appdevcon.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

  @Rule
  public ActivityTestRule<LoginActivity> activityTestRule =
      new ActivityTestRule<>(LoginActivity.class);

  @Test
  public void nameMissing() throws Exception {
    clickLogin();
    checkError(R.string.login_user_missing);
  }

  @Test
  public void nameTooShort() throws Exception {
    onView(withId(R.id.login_user))
        .perform(typeText("123"), closeSoftKeyboard());
    clickLogin();
    checkError(R.string.login_user_too_short);
  }

  @Test
  public void loginSuccessful() throws Exception {
    onView(withId(R.id.login_user))
        .perform(typeText("tpinto"), closeSoftKeyboard());
    clickLogin();
    onView(withText(R.string.app_name))
        .check(matches(isDisplayed()));
  }

  private void clickLogin() {
    onView(withText(R.string.login_submit))
        .perform(click());
  }

  private void checkError(@StringRes int errorRes) {
    onView(withText(errorRes))
        .check(matches(isDisplayed()));
  }
}
