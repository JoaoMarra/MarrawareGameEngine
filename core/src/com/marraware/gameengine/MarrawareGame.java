package com.marraware.gameengine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.marraware.gameengine.helpers.AssetsLoader;
import com.marraware.gameengine.helpers.GameWorld;
import com.marraware.gameengine.marraScenes.MarraScene;

public class MarrawareGame extends Game {
	@Override
	public void create() {
		AssetsLoader.load();
		GameWorld gameWorld = new GameWorld();
		setScreen(gameWorld.getScreen());

		gameWorld.setScene(new MarraScene() {
			@Override
			public void update(float delta) {

			}

			@Override
			public boolean keyDown(int keycode) {
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				return false;
			}
		});
	}

	@Override
	public void dispose() {
		AssetsLoader.dispose();
		super.dispose();
	}
}
