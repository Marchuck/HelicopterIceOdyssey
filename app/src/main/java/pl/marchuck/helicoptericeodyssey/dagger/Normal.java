package pl.marchuck.helicoptericeodyssey.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Łukasz Marczak
 *
 * @since 23.02.16
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Normal {
}
