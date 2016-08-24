package pl.marchuck.helicoptericeodyssey.rxcache;

import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.EvictProvider;
import io.rx_cache.LifeCache;
import pl.marchuck.helicoptericeodyssey.rxcache.models.Poke;
import rx.Observable;

/**
 * @author Lukasz Marczak
 * @since 24.08.16.
 */
public interface Providers {

    @LifeCache(duration = 12, timeUnit = TimeUnit.HOURS)
    rx.Observable<Poke> getPoke(Observable<Poke> pok  );
}
