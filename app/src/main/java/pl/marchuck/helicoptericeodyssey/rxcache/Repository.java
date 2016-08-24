package pl.marchuck.helicoptericeodyssey.rxcache;

import java.io.File;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.EvictProvider;
import io.rx_cache.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import pl.marchuck.helicoptericeodyssey.rxcache.models.Poke;
import rx.Observable;

/**
 * @author Lukasz Marczak
 * @since 24.08.16.
 */
public class Repository {
    private final Providers providers;

    public Repository(File cacheDir) {
        providers = new RxCache.Builder()
                .useExpiredDataIfLoaderNotAvailable(true)
                .persistence(cacheDir, new GsonSpeaker())
                .using(Providers.class);
    }


    public Observable<Poke> getMocks(final API api) {
        return providers.getPoke(api.latest());
    }
}
