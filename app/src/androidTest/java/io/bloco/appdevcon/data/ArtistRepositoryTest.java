package io.bloco.appdevcon.data;

import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import io.bloco.appdevcon.AndroidApplication;
import io.bloco.appdevcon.common.di.ApplicationComponent;
import io.bloco.appdevcon.data.model.Artist;
import io.bloco.appdevcon.testing.TestStateManager;
import io.bloco.faker.Faker;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class ArtistRepositoryTest {

  private ArtistRepository artistRepository;
  private SQLiteDatabase db;

  @Before
  public void setUp() throws Exception {
    ApplicationComponent applicationComponent =
        ((AndroidApplication) InstrumentationRegistry.getTargetContext()
            .getApplicationContext()).getApplicationComponent();

    db = applicationComponent.db();
    artistRepository = new ArtistRepository(db);
  }

  @After
  public void tearDown() throws Exception {
    new TestStateManager().logout();
  }

  @Test
  public void saveAndGetAll() throws Exception {
    Artist artist = new Artist();
    artist.setId(new Faker().number.positive());

    artistRepository.save(Arrays.asList(artist));

    List<Artist> retrievedArtists = artistRepository.getAll();
    assertThat(retrievedArtists, is(hasSize(1)));
    assertThat(retrievedArtists.get(0), is(equalTo(artist)));
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