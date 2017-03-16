package io.bloco.appdevcon.domain;

import io.bloco.appdevcon.data.ArtistRepository;
import io.bloco.appdevcon.data.TrackRepository;
import io.bloco.appdevcon.data.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogoutTest {

  @InjectMocks Logout logout;
  @Mock UserRepository userRepository;
  @Mock ArtistRepository artistRepository;
  @Mock TrackRepository trackRepository;

  @Test
  public void logout() throws Exception {
    logout.logout();

    verify(userRepository).delete();
    verify(artistRepository).deleteAll();
    verify(trackRepository).deleteAll();
  }
}