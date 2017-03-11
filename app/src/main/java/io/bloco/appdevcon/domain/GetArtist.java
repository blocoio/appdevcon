package io.bloco.appdevcon.domain;

import io.bloco.appdevcon.common.di.PerApplication;
import io.bloco.appdevcon.data.ArtistRepository;
import io.bloco.appdevcon.data.model.Artist;
import javax.inject.Inject;

@PerApplication
public class GetArtist {

  private final ArtistRepository artistRepository;

  @Inject public GetArtist(ArtistRepository artistRepository) {
    this.artistRepository = artistRepository;
  }

  public Artist get(long artistId) {
    return artistRepository.get(artistId);
  }
}
