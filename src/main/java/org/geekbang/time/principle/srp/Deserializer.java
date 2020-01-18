package org.geekbang.time.principle.srp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Collections;
import java.util.Map;

public class Deserializer {

    private static final String IDENTIFIER_STRING = "UEUEUE;";
    private Gson gson;

    public Deserializer() {
        this.gson = new Gson();
    }

    public Map<String, String> deserialize(String text) {
        if (!text.startsWith(IDENTIFIER_STRING)) {
            return Collections.emptyMap();
        }
        String gsonStr = text.substring(IDENTIFIER_STRING.length());
        return gson.fromJson(gsonStr, new TypeToken<Map<String, String>>(){}.getType());
    }

}
