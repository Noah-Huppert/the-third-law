package com.noahhuppert.thethirdlaw.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.noahhuppert.thethirdlaw.helpers.Shapes;

public class Entity implements Renderable {
    public Sprite sprite;
    public Body body;
    public PolygonShape shape;
    public Fixture fixture;

    public Entity(Vector2 position, float rotation, Vector2 size, Texture texture, final World world) {
        sprite = new Sprite(texture);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);
        bodyDef.angle = rotation;

        body = world.createBody(bodyDef);

        shape = new PolygonShape();
        shape.setAsBox(size.x, size.y);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0.6f;

        fixture = body.createFixture(fixtureDef);
    }

    @Override
    public void update() {
        sprite.setOriginCenter();
        sprite.setPosition(getCenterPosition().x, getCenterPosition().y);
        sprite.setRotation(getRotation() * MathUtils.radiansToDegrees);
        sprite.setSize(getSize().x, getSize().y);
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void dispose() {
        shape.dispose();
    }

    /* Getters */
    public Vector2 getPosition() {
        return body.getPosition();
    }

    public Vector2 getCenterPosition() {
        Vector2 size = getSize();
        Vector2 pos = body.getPosition();
        pos.x -= size.x / 2;
        pos.y -= size.y / 2;

        return pos;
    }

    /**
     * @return Rotation in radians
     */
    public float getRotation() {
        return body.getTransform().getRotation();
    }

    public Vector2 getSize() {
        return Shapes.getPolygonBoundingBox(shape);
    }

    /* Setters */
    public void setPosition(Vector2 position) {
        body.setTransform(position, getRotation());
    }

    /**
     * @param rotation New rotation in radians
     */
    public void setRotation(float rotation) {
        body.setTransform(getPosition(), rotation);
    }

    public void setSize(Vector2 size) {
        shape.setAsBox(size.x, size.y);
    }
}
