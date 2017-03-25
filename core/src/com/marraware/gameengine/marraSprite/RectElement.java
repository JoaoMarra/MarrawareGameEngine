package com.marraware.gameengine.marraSprite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.marraware.gameengine.helpers.MarraRect;

/**
 * Created by joaogabrielsilvamarra on 25/03/17.
 */

public class RectElement extends ShapeElement {

    private MarraRect boundaries;

    public RectElement(MarraRect boundaries, Color color, ShapeRenderer.ShapeType shapeType) {
        this.boundaries = boundaries;
        this.color = color;
        this.shapeType = shapeType;
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, float scaleX, float scaleY) {
        shapeRenderer.begin(shapeType);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(boundaries.left()*scaleX,boundaries.top()*scaleY,boundaries.width()*scaleX,boundaries.height()*scaleY);
        shapeRenderer.end();
    }
}
