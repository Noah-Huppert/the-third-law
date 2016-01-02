package com.noahhuppert.thethirdlaw.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.noahhuppert.thethirdlaw.MainGame;
import com.noahhuppert.thethirdlaw.helpers.Graphics;
import com.noahhuppert.thethirdlaw.helpers.Math;
import com.noahhuppert.thethirdlaw.helpers.Shapes;
import com.noahhuppert.thethirdlaw.models.Entity;

public class GameView implements Screen {
    private static final String TAG = GameView.class.getSimpleName();
    private MainGame mainGame;

    private OrthographicCamera camera;
    private World world;
    private Box2DDebugRenderer debugRenderer;

    private Entity player;

    public GameView(MainGame mainGame) {
        this.mainGame = mainGame;

        camera = new OrthographicCamera(MainGame.WIDTH, MainGame.HEIGHT);
        camera.setToOrtho(false);

        world = new World(new Vector2(0, 0), true);
        debugRenderer = new Box2DDebugRenderer();

        player = new Entity(Graphics.getScreenCenter(), 0, new Vector2(20, 20), new Texture("player.png"), world);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        mainGame.spriteBatch.setProjectionMatrix(camera.combined);

        world.step(1/45f, 6, 2);

        if(Gdx.input.isTouched()) {
            Gdx.app.debug(TAG, "Fire");
        }

        // Rotate player to face mouse
        float playerRotation = MathUtils.atan2(Graphics.getScreenCenter().y - Gdx.input.getY(), Graphics.getScreenCenter().x - Gdx.input.getX());
        playerRotation *= -1;
        playerRotation += Math.common(1, 2);
        player.setRotation(playerRotation);

        mainGame.spriteBatch.begin();

        player.render(mainGame.spriteBatch);

        mainGame.spriteBatch.end();

        debugRenderer.render(world, camera.combined);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
