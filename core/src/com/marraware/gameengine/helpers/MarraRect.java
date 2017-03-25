package com.marraware.gameengine.helpers;

/**
 * Created by joaogabrielsilvamarra on 25/03/17.
 */

public class MarraRect {

    private float left,top,width,height;

    public MarraRect(float left, float top, float width, float height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public final MarraRect clone() {
        return new MarraRect(left,top,width,height);
    }

    public MarraRect move(float x, float y) {
        left += x;
        top += y;

        return this;
    }

    public MarraRect scale(float scaleX, float scaleY) {
        MarraRect rect = clone();
        rect.left *= scaleX;
        rect.top *= scaleY;
        rect.width *= scaleX;
        rect.height *= scaleY;

        return rect;
    }

    public float centerX() {
        return left+width/2;
    }

    public float centerY() {
        return top+height/2;
    }

    public float right() {
        return left+width;
    }

    public float bottom() {
        return top+height;
    }

    public float left() {
        return left;
    }

    public float top() {
        return top;
    }

    public float width() {
        return width;
    }

    public float height() {
        return height;
    }

    public final boolean intersect(MarraRect rect) {
        if(rect.left() > right())
            return false;
        if(rect.right() < left())
            return false;
        if(rect.top() > bottom())
            return false;
        if(rect.bottom() < top())
            return false;

        return true;
    }

    public final boolean contains(MarraRect rect) {
        if(rect.left() >= right())
            return false;
        if(rect.right() <= left())
            return false;
        if(rect.top() >= bottom())
            return false;
        if(rect.bottom() <= top())
            return false;

        return true;
    }
}
