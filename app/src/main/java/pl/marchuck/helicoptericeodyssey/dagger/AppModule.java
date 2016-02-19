package pl.marchuck.helicoptericeodyssey.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.marchuck.helicoptericeodyssey.R;
import pl.marchuck.helicoptericeodyssey.network.SWApi;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Łukasz Marczak
 *
 * @since 19.02.16
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides @Singleton public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides @Singleton public MediaPlayer provideMediaPlayer() {
        return MediaPlayer.create(app, R.raw.win95);
    }

    @Provides
    @Singleton
    Vibrator provideVibrator() {
        return (Vibrator) app.getSystemService(Context.VIBRATOR_SERVICE);
    }


    @Provides
    @Singleton
    SWApi provideSWApi() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(SWApi.endpoint)
                .setConverter(new GsonConverter(new Gson()))
                .build();
        return adapter.create(SWApi.class);
    }

}
