package io.bloco.appdevcon.common.di;

import dagger.Subcomponent;
import io.bloco.appdevcon.ui.artist.TrackItemView;
import io.bloco.appdevcon.ui.main.ArtistItemView;

@PerView @Subcomponent(modules = ViewModule.class) public interface ViewComponent {
  void inject(ArtistItemView artistItemView);

  void inject(TrackItemView trackItemView);
}