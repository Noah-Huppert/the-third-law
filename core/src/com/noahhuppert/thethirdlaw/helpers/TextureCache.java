package com.noahhuppert.thethirdlaw.helpers;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class TextureCache {
    private Map<String, Texture> textureCache;

    private static TextureCache instance;

    private TextureCache() {
        textureCache = new HashMap<String, Texture>();
    }

    public static TextureCache getInstance() {
        if(instance == null) {
            instance = new TextureCache();
        }

        return instance;
    }

    public Texture getImageTexture(String key) {
        if(!textureCache.containsKey(key)) {
            textureCache.put(key, new Texture(key));
        }

        return textureCache.get(key);
    }
}
