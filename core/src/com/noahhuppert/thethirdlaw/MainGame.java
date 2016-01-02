package com.noahhuppert.thethirdlaw;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.noahhuppert.thethirdlaw.views.GameView;

public class MainGame extends Game {
    public static final boolean DEBUG = true;
    private static final String TAG = MainGame.class.getSimpleName();

	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;

	public SpriteBatch spriteBatch;

	private Screen screen;

	@Override
	public void create () {
        if(DEBUG) {
            Gdx.app.setLogLevel(Application.LOG_DEBUG);
        }

		spriteBatch = new SpriteBatch();

		screen = new GameView(this);
		setScreen(screen);
	}

    @Override
    public void dispose() {
        super.dispose();

        spriteBatch.dispose();
    }
}
