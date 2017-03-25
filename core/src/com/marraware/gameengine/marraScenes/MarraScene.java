package com.marraware.gameengine.marraScenes;

import com.badlogic.gdx.InputProcessor;
import com.marraware.gameengine.marraSprite.ShapeElement;
import com.marraware.gameengine.marraSprite.SpriteElement;

import java.util.ArrayList;

/**
 * Created by joaogabrielsilvamarra on 25/03/17.
 */

public abstract class MarraScene implements InputProcessor {

    private float centerX,centerY;
    private ArrayList<SpriteElement> spriteElements;
    private ArrayList<ShapeElement> shapeElements;

    public MarraScene() {
        centerX = 0;
        centerX = 0;
        spriteElements = new ArrayList<SpriteElement>();
        shapeElements = new ArrayList<ShapeElement>();
    }

    public final void setCenter(float centerX, float centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public float centerX() {
        return centerX;
    }

    public float centerY() {
        return centerY;
    }

    public ArrayList<SpriteElement> getSpriteElements() {
        return spriteElements;
    }

    public abstract void update(float delta);

}
