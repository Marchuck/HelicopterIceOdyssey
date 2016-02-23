package pl.marchuck.helicoptericeodyssey.dagger;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Łukasz Marczak
 *
 * @since 23.02.16
 */

public class StringDeserializer implements JsonDeserializer<String> {

    String s;

    public StringDeserializer(String s) {
        this.s = s;
    }

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return s;
    }
}