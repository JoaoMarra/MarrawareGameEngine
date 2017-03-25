package com.marraware.gameengine.marraSprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.marraware.gameengine.helpers.MarraRect;

/**
 * Created by joaogabrielsilvamarra on 25/03/17.
 */

public abstract class SpriteElement {

    private MarraRect boundaries;

    public abstract TextureRegion drawRegion();

    public final boolean contains(MarraRect rect) {
        if(boundaries == null)
            return false;
        return boundaries.intersect(rect);
    }

    public final void draw(SpriteBatch spriteBatch, float scaleX, float scaleY) {
        TextureRegion region = drawRegion();
        if(region == null)
            return;

        MarraRect scale = boundaries.scale(scaleX, scaleY);
        spriteBatch.draw(region,scale.left(),scale.top(),scale.width(),scale.height());
    }
}
