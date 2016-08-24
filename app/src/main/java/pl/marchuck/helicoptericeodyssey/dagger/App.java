package pl.marchuck.helicoptericeodyssey.dagger;

import android.app.Application;
import android.content.Context;

import java.io.File;

import io.rx_cache.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import pl.marchuck.helicoptericeodyssey.rxcache.Providers;
import pl.marchuck.helicoptericeodyssey.rxcache.Repository;

/**
 * Created by Łukasz Marczak
 *
 * @since 19.02.16
 */
public class App extends Application {

    public Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        File cacheDir = getFilesDir();
        repository = new Repository(cacheDir);

    }

}
