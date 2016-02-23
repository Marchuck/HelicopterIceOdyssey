package pl.marchuck.helicoptericeodyssey.dagger;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import pl.marchuck.helicoptericeodyssey.network.SWApi;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Łukasz Marczak
 *
 * @since 23.02.16
 */
//@Module
public class SecondModule {

    public SecondModule() {
    }


    //  @Provides
    // @Singleton
    SWApi provideSWApi() {

        Type token = new TypeToken<String>() {
        }.getType();

        GsonBuilder builder = new GsonBuilder()
                .registerTypeAdapter(token, new StringDeserializer("HEHESZKI"));
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(SWApi.endpoint)
                .setConverter(new GsonConverter(builder.create()))
                .build();

        return adapter.create(SWApi.class);
    }

}
