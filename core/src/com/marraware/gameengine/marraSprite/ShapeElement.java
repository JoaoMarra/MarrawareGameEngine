package com.marraware.gameengine.marraSprite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by joaogabrielsilvamarra on 25/03/17.
 */

public abstract class ShapeElement {

    protected Color color;
    protected ShapeRenderer.ShapeType shapeType;
    public abstract void draw(ShapeRenderer shapeRenderer, float scaleX, float scaleY);
}
