package com.marraware.gameengine.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by joaogabrielsilvamarra on 25/03/17.
 */

public class AssetsLoader {

    private static HashMap<String, Texture> Texturas;

    public static void load() {
        Texturas = new HashMap<String, Texture>();
    }

    public static void dispose() {
        Set<String> s=Texturas.keySet();
        Iterator<String> ss = s.iterator();
        while(ss.hasNext())
            Texturas.get(ss.next()).dispose();
        Texturas.clear();
    }
    public static Texture getTexture(String key)
    {
        Texture ret = null;
        if(Texturas.containsKey(key))
            ret =  Texturas.get(key);
        else {
            try {
                ret = new Texture(Gdx.files.internal(key + ".png"));
                Texturas.put(key, ret);
            }catch (Exception e) {
                System.out.println("AssetLoader: Error getting texture");
            }
        }
        return ret;
    }
}
