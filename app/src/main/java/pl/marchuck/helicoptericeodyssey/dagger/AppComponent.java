package pl.marchuck.helicoptericeodyssey.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.marchuck.helicoptericeodyssey.ui.DaggerActivity;
import pl.marchuck.helicoptericeodyssey.ui.MainActivity;

/**
 * Created by Łukasz Marczak
 *
 * @since 19.02.16
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    MainActivity inject(MainActivity activity);

    DaggerActivity inject(DaggerActivity activity);

}
