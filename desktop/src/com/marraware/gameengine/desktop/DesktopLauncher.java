package com.marraware.gameengine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.marraware.gameengine.MarrawareGame;
import com.marraware.gameengine.helpers.GameWorld;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Marraware";
		config.width = (int) (GameWorld.WORLD_WIDTH*2);
		config.height = (int) (GameWorld.WORLD_HEIGHT*2);
		new LwjglApplication(new MarrawareGame(), config);
	}
}
