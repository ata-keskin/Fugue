package pn.eu.firetrail.fugue.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import pn.eu.firetrail.fugue.Game;

public class Utils {
	
	private static int counter = 0;
	
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Utils.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static void drawDebugGrid(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		int w = Math.round(Game.tileWidth);
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 20; j++) {
			graphics.drawRect(j * w, i * w, w, w);
			}
		}
	}
	
	public static boolean doEverySecond(int seconds, int FPS) {
		if(counter == FPS * seconds) {
			counter = 0;
			return true;
		} else {
			counter++;
			return false;
		}
	}
	
	public static Vector2f getTileCoor(Vector2f pos) {
		Vector2f tile_coor = new Vector2f((float)Math.floor((double)pos.x/Game.tileWidth), (float)Math.floor((double)pos.y/Game.tileWidth));
		return tile_coor;
	}
	
}
