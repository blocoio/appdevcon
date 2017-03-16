package io.bloco.appdevcon.domain;

import io.bloco.appdevcon.data.ArtistRepository;
import io.bloco.appdevcon.data.TrackRepository;
import io.bloco.appdevcon.data.api.LastFmApi;
import io.bloco.appdevcon.data.api.response.TopTracksResponse;
import io.bloco.appdevcon.data.model.Artist;
import io.bloco.appdevcon.data.model.Track;
import io.bloco.appdevcon.domain.common.DomainCallback;
import io.bloco.appdevcon.factories.TrackFactory;
import io.bloco.faker.Faker;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okhttp3.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetArtistTopTracksTest {

  @Mock LastFmApi lastFmApi;
  @Mock ArtistRepository artistRepository;
  @Mock TrackRepository trackRepository;
  @InjectMocks GetArtistTopTracks getArtistTopTracks;

  private TrackFactory trackFactory = new TrackFactory();
  private Faker faker;

  @Test
  public void get_fromDb() throws Exception {
    List<Track> tracks = trackFactory.buildList(3);
    when(trackRepository.getByArtist(anyLong())).thenReturn(tracks);
    DomainCallback<List<Track>> domainCallback = mock(DomainCallback.class);

    getArtistTopTracks.get(123L, domainCallback);

    verify(domainCallback).onSuccess(eq(tracks));
    verify(lastFmApi, never()).getArtistTopTracks(anyString());
  }

  @Test
  public void get_fromApi() throws Exception {
    when(trackRepository.getByArtist(anyLong())).thenReturn(Collections.EMPTY_LIST);
    List<Track> tracks = trackFactory.buildList(3);
    DomainCallback<List<Track>> domainCallback = mock(DomainCallback.class);
    Artist artist = new Artist();
    faker = new Faker();
    artist.setId(faker.number.positive());
    artist.setName(faker.name.name());
    when(artistRepository.get(anyLong())).thenReturn(artist);
    when(lastFmApi.getArtistTopTracks(anyString())).thenReturn(new TopCall(tracks));

    getArtistTopTracks.get(123L, domainCallback);

    verify(lastFmApi).getArtistTopTracks(eq(artist.name()));
    verify(domainCallback).onSuccess(eq(tracks));
  }

  public static class TopCall implements Call<TopTracksResponse> {

    private List<Track> tracks;

    public TopCall(List<Track> tracks) {
      this.tracks = tracks;
    }

    @Override public Response<TopTracksResponse> execute() throws IOException {
      return null;
    }

    @Override public void enqueue(Callback<TopTracksResponse> callback) {
      TopTracksResponse.TopTrack topTrack = new TopTracksResponse.TopTrack();
      topTrack.setTracks(tracks);
      TopTracksResponse topTracksResponse = new TopTracksResponse();
      topTracksResponse.setTopTracks(topTrack);
      callback.onResponse(this, Response.success(topTracksResponse));
    }

    @Override public boolean isExecuted() {
      return false;
    }

    @Override public void cancel() {

    }

    @Override public boolean isCanceled() {
      return false;
    }

    @Override public Call<TopTracksResponse> clone() {
      return null;
    }

    @Override public Request request() {
      return null;
    }
  }
}