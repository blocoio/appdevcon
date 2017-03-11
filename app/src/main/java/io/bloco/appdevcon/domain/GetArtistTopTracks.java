package io.bloco.appdevcon.domain;

import io.bloco.appdevcon.common.di.PerApplication;
import io.bloco.appdevcon.data.ArtistRepository;
import io.bloco.appdevcon.data.TrackRepository;
import io.bloco.appdevcon.data.api.LastFmApi;
import io.bloco.appdevcon.data.api.response.TopTracksResponse;
import io.bloco.appdevcon.data.model.Artist;
import io.bloco.appdevcon.data.model.Track;
import io.bloco.appdevcon.domain.common.ApiError;
import io.bloco.appdevcon.domain.common.DomainCallback;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@PerApplication
public class GetArtistTopTracks {

  private final LastFmApi lastFmApi;
  private final ArtistRepository artistRepository;
  private final TrackRepository trackRepository;

  @Inject public GetArtistTopTracks(LastFmApi lastFmApi, ArtistRepository artistRepository,
      TrackRepository trackRepository) {
    this.lastFmApi = lastFmApi;
    this.artistRepository = artistRepository;
    this.trackRepository = trackRepository;
  }

  public void get(final long artistId, final DomainCallback<List<Track>> domainCallback) {
    List<Track> tracks = trackRepository.getByArtist(artistId);
    if (!tracks.isEmpty()) {
      domainCallback.onSuccess(tracks);
      return;
    }

    Artist artist = artistRepository.get(artistId);
    lastFmApi.getArtistTopTracks(artist.name())
        .enqueue(new Callback<TopTracksResponse>() {
          @Override
          public void onResponse(Call<TopTracksResponse> call,
              Response<TopTracksResponse> response) {
            if (!response.isSuccessful()) {
              domainCallback.onError(new ApiError());
            } else {
              List<Track> tracks = response.body().getTopTracks().getTracks();
              trackRepository.save(artistId, tracks);
              domainCallback.onSuccess(tracks);
            }
          }

          @Override
          public void onFailure(Call<TopTracksResponse> call, Throwable t) {
            domainCallback.onError(t);
          }
        });
  }
}
