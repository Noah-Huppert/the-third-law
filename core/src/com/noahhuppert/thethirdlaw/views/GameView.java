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
import com.noahhuppert.thethirdlaw.helpers.TextureCache;
import com.noahhuppert.thethirdlaw.models.Entity;
import com.noahhuppert.thethirdlaw.models.Player;
import com.noahhuppert.thethirdlaw.models.Renderable;

import java.util.ArrayList;
import java.util.List;

public class GameView implements Screen {
    private static final String TAG = GameView.class.getSimpleName();
    private MainGame mainGame;

    private OrthographicCamera camera;
    private World world;

    private List<Renderable> renderables;

    private Player player;

    public GameView(MainGame mainGame) {
        this.mainGame = mainGame;

        camera = new OrthographicCamera(MainGame.WIDTH, MainGame.HEIGHT);
        camera.setToOrtho(false);

        world = new World(new Vector2(0, 0), true);

        renderables = new ArrayList<>();

        player = new Player();
        renderables.add(player);
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

        // Renderable.update
        for(Renderable r : renderables) {
            r.update();
        }

        if(Gdx.input.isTouched()) {
            Gdx.app.debug(TAG, "Fire");
        }

        mainGame.spriteBatch.begin();

        // Renderable.render
        for(Renderable r : renderables) {
            r.render(mainGame.spriteBatch);
        }

        mainGame.spriteBatch.end();
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
        // Renderable.dispose
        for(Renderable r : renderables) {
            r.dispose();
        }
    }
}
