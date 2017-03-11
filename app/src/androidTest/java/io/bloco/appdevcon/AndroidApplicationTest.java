package io.bloco.appdevcon;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AndroidApplicationTest {

  @Test
  public void start() throws Exception {
    assertNotNull(InstrumentationRegistry.getTargetContext());
  }
}
