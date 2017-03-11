package io.bloco.appdevcon.data;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import io.bloco.appdevcon.AndroidApplication;
import io.bloco.appdevcon.common.di.ApplicationComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ArtistRepositoryTest {

  private ArtistRepository artistRepository;

  @Before
  public void setUp() throws Exception {
    ApplicationComponent applicationComponent =
        ((AndroidApplication) InstrumentationRegistry.getTargetContext()
            .getApplicationContext()).getApplicationComponent();

    artistRepository = new ArtistRepository(applicationComponent.db());
  }

  @Test
  public void saveAndGetAll() throws Exception {
    // TODO
  }

  @Test
  public void saveAndGet() throws Exception {
    // TODO
  }

  @Test
  public void deleteAll() throws Exception {
    // TODO
  }
}