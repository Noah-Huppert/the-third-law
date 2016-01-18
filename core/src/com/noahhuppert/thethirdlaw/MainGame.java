package com.noahhuppert.thethirdlaw;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.noahhuppert.thethirdlaw.views.GameView;

import java.util.Map;

public class MainGame extends Game {
    public static final boolean DEBUG = true;
    private static final String TAG = MainGame.class.getSimpleName();

	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;

	public SpriteBatch spriteBatch;

	@Override
	public void create () {
        Gdx.graphics.setTitle("The Third Law");

        if(DEBUG) {
            Gdx.app.setLogLevel(Application.LOG_DEBUG);
        }

		spriteBatch = new SpriteBatch();

		setScreen(new GameView(this));
	}

    @Override
    public void dispose() {
        super.dispose();

        spriteBatch.dispose();
    }
}
