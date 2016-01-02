package com.noahhuppert.thethirdlaw.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Graphics {
    public static Vector2 getScreenCenter() {
        return new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }
}
