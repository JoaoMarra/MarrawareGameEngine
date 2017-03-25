package com.marraware.gameengine.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.marraware.gameengine.marraScenes.MarraScene;

/**
 * Created by joaogabrielsilvamarra on 25/03/17.
 */

public class GameWorld {

    public static final float WORLD_WIDTH = 240;
    public static final float WORLD_HEIGHT = 400;

    private MarraScene scene;
    private GameScreen screen;
    private GameRenderer renderer;

    public GameWorld() {
        screen = new GameScreen();
        renderer = new GameRenderer();
    }

    public void setScene(MarraScene scene) {
        this.scene = scene;
        renderer.setScene(scene);

        Gdx.input.setInputProcessor(scene);
    }

    public GameScreen getScreen() {
        return screen;
    }

    class GameScreen implements Screen {

        @Override
        public void show() {

        }

        @Override
        public void render(float delta) {
            if(scene != null) {
                scene.update(delta);
                renderer.render();
            }
        }

        @Override
        public void resize(int width, int height) {
            renderer.updateRender();
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

        }
    }
}
