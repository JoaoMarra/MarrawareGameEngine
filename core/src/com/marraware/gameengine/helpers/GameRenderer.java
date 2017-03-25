package com.marraware.gameengine.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.marraware.gameengine.marraScenes.MarraScene;
import com.marraware.gameengine.marraSprite.SpriteElement;

import java.util.ArrayList;

/**
 * Created by joaogabrielsilvamarra on 25/03/17.
 */

public class GameRenderer {

    private MarraScene scene;
    public float gameWidth,gameHeight;
    public float scaleX,scaleY;

    private OrthographicCamera camO;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch sbatch;

    public GameRenderer() {
        camO = new OrthographicCamera();
        camO.setToOrtho(true, GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camO.combined);

        sbatch = new SpriteBatch();
        sbatch.setProjectionMatrix(camO.combined);

        updateRender();
    }

    public void updateRender() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        gameWidth = screenWidth;
        gameHeight = screenHeight;
        scaleX = GameWorld.WORLD_WIDTH/screenWidth;
        scaleY = GameWorld.WORLD_HEIGHT/screenHeight;
        System.out.println(gameWidth + " : " + gameHeight);
        System.out.println(scaleX + " x " + scaleY);

        render();
    }

    public void setScene(MarraScene scene) {
        this.scene = scene;
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        if(scene == null)
            return;

        ArrayList<SpriteElement> elements = scene.getSpriteElements();
        MarraRect worldRect = new MarraRect(scene.centerX()-gameWidth/2,scene.centerY()-gameHeight/2,
                gameWidth,gameHeight);

        for(SpriteElement element : elements) {
            if(element.contains(worldRect)) {
                element.draw(sbatch, scaleX, scaleY);
            }
        }

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(1*scaleX,1*scaleY,worldRect.width()*scaleX-1*scaleX,worldRect.height()*scaleY-1*scaleY);
        shapeRenderer.end();
    }
}
