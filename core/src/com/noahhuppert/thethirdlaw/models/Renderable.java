package com.noahhuppert.thethirdlaw.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Renderable {
    void update();
    void render(SpriteBatch batch);
    void dispose();
}
