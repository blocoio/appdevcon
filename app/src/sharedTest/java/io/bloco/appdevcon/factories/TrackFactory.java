package io.bloco.appdevcon.factories;

import io.bloco.appdevcon.data.model.Track;

public class TrackFactory extends BaseFactory<Track> {

  @Override Track build() {
    Track track = new Track();
    track.setName(faker.name.name());
    track.setId(faker.number.positive());
    return track;
  }
}
