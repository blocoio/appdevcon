package io.bloco.appdevcon.common.di;

import dagger.Subcomponent;
import io.bloco.appdevcon.ui.artist.ArtistActivity;
import io.bloco.appdevcon.ui.login.LoginActivity;
import io.bloco.appdevcon.ui.main.MainActivity;

@PerActivity @Subcomponent(modules = ActivityModule.class) public interface ActivityComponent {
  ViewComponent plus(ViewModule viewModule);

  void inject(MainActivity activity);

  void inject(LoginActivity loginActivity);

  void inject(ArtistActivity artistActivity);
}
