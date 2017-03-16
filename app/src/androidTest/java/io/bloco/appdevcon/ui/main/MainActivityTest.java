package io.bloco.appdevcon.ui.main;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import io.bloco.appdevcon.testing.TestStateManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule<>(MainActivity.class, true, false);

  @Before
  public void setUp() throws Exception {
    new TestStateManager().login();
    activityTestRule.launchActivity(null);
  }

  @After
  public void tearDown() throws Exception {
    new TestStateManager().logout();
  }

  @Test
  public void showUserName() throws Exception {
    onView(withText("Sérgio Santos")).check(matches(isDisplayed()));
  }

  @Test
  public void showArtistList() throws Exception {
    onView(withText("Arctic Monkeys")).check(matches(isDisplayed()));
  }
}
