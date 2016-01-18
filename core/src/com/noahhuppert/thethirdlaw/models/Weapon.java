package com.noahhuppert.thethirdlaw.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Weapon implements Renderable {
    private Sprite sprite;

    private float fireRate;
    private int clipSize;

    public Weapon(Texture texture) {
        this.sprite = new Sprite(texture);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void dispose() {

    }
}
