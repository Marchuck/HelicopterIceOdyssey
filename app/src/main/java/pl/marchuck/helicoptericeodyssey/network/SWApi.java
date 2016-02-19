package pl.marchuck.helicoptericeodyssey.network;

import pl.marchuck.helicoptericeodyssey.model.Character;
import retrofit.http.GET;
import retrofit.http.Path;
/**
 * Created by Łukasz Marczak
 *
 * @since 19.02.16
 */
public interface SWApi {
    String endpoint = "http://swapi.co/api";

    @GET("/people/{id}/")
    rx.Observable<Character> getCharacter(@Path("id") int id);
}
