package com.noahhuppert.thethirdlaw.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Player implements Renderable {
    private Entity body;
    private Weapon weapon;

    public Player(final World world) {
        this.body = new Entity(Vector2.Zero, 0, new Vector2(10, 10), new Texture("player.png"), world);

    }

    @Override
    public void update() {
        body.update();
        weapon.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        body.render(batch);
        weapon.render(batch);
    }

    @Override
    public void dispose() {
        weapon.dispose();
        body.dispose();
    }
}
