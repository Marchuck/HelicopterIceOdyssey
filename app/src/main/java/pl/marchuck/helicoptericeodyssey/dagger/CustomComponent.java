package pl.marchuck.helicoptericeodyssey.dagger;

import pl.marchuck.helicoptericeodyssey.ui.DaggerActivity;
import pl.marchuck.helicoptericeodyssey.ui.MainActivity;

/**
 * Created by Łukasz Marczak
 *
 * @since 23.02.16
 */
//@Customized
//@Subcomponent(modules = {SecondModule.class})
public interface CustomComponent {

    MainActivity inject(MainActivity activity);

    DaggerActivity inject(DaggerActivity activity);
}
