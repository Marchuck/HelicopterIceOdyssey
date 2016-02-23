package pl.marchuck.helicoptericeodyssey.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.marchuck.helicoptericeodyssey.network.SWApi;
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
//    CustomComponent nazwaBezZnaczenia(SecondModule userModule);

    MainActivity inject(MainActivity activity);

    DaggerActivity inject(DaggerActivity activity);

    SWApi provideSwapi();

    @Extra
    SWApi provideExtraSwapi();


}
