package pl.marchuck.helicoptericeodyssey.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.lukmarr.blueduff.BlueDuff;
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

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    @Singleton
    public MediaPlayer provideMediaPlayer() {
        return MediaPlayer.create(app, R.raw.win95);
    }

    @Provides
    @Singleton
    Vibrator provideVibrator() {
        return (Vibrator) app.getSystemService(Context.VIBRATOR_SERVICE);
    }

    @Provides
    SWApi provideSWApi() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(SWApi.endpoint)
                .setConverter(new GsonConverter(new Gson()))
                .build();
        return adapter.create(SWApi.class);
    }

    @Provides
    @Extra
    SWApi provideSWApi2() {

        Type token = new TypeToken<String>() {
        }.getType();

        GsonBuilder builder = new GsonBuilder()
                .registerTypeAdapter(token, new StringDeserializer("HEHESZKI XXDD"));
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(SWApi.endpoint)
                .setConverter(new GsonConverter(builder.create()))
                .build();
        return adapter.create(SWApi.class);
    }

    @Provides
    @Normal
    SWApi provideSWApi3() {

        Type token = new TypeToken<String>() {
        }.getType();

        GsonBuilder builder = new GsonBuilder()
                .registerTypeAdapter(token, new StringDeserializer("zbyt zajebisty ten dagger"));
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(SWApi.endpoint)
                .setConverter(new GsonConverter(builder.create()))
                .build();
        return adapter.create(SWApi.class);
    }


    @Provides
    @Singleton
    BlueDuff providesBlueDuff() {
        return new BlueDuff(1024, 50);
    }

}
