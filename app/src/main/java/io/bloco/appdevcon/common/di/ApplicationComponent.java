package io.bloco.appdevcon.common.di;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import com.google.gson.Gson;
import dagger.Component;
import io.bloco.appdevcon.data.ArtistRepository;
import io.bloco.appdevcon.data.TrackRepository;
import io.bloco.appdevcon.data.UserRepository;
import io.bloco.appdevcon.domain.Logout;

@PerApplication @Component(modules = {
    ApplicationModule.class, ApiModule.class
})
public interface ApplicationComponent {
  ActivityComponent plus(ActivityModule activityModule);

  UserRepository userRepository();

  ArtistRepository artistRepository();

  SharedPreferences sharePreferences();

  Logout logout();

  Gson gson();

  SQLiteDatabase db();

  TrackRepository trackRepository();
}
