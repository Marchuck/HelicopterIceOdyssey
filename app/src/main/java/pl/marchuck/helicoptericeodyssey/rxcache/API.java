package pl.marchuck.helicoptericeodyssey.rxcache;

import android.util.Log;

import com.google.gson.Gson;

import pl.marchuck.helicoptericeodyssey.rxcache.models.Poke;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * @author Lukasz Marczak
 * @since 24.08.16.
 */
public class API {

    public static final String TAG = API.class.getSimpleName();

    private static final String endpoint = "http://pokeapi.co/api/v2";

    private PokeAPI pokeAPI;

    private RestAdapter adapter;


    public static <T> T buildAPI(RestAdapter adapter, Class<T> klazz) {
        return adapter.create(klazz);
    }

    public API() {
        adapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setConverter(new GsonConverter(new Gson()))
                .build();
        pokeAPI = buildAPI(adapter, PokeAPI.class);
    }

    public rx.Observable<Poke> latest() {
        Log.d(TAG, "latest: ");
        return pokeAPI.getPoke(1);
    }

    public interface PokeAPI {
        @GET("/pokemon/{id}")
        rx.Observable<Poke> getPoke(@Path("id") int id);
    }

}
