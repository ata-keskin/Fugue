package pn.eu.firetrail.fugue.graphics;

import java.awt.image.BufferedImage;

import pn.eu.firetrail.fugue.utils.Utils;

public class SpriteSheet {
	
	private BufferedImage[] ss;
	
	public SpriteSheet(String[] path) {
		ss = new BufferedImage[path.length];
		for (int i = 0; i < path.length; i++) {
			ss[i] = Utils.loadImage(path[i]);
		}
		
	}
	
	public BufferedImage getSprite(SpriteData s) {
		return ss[s.sprite_sheet].getSubimage(s.sheet_pos.x(), s.sheet_pos.y(), s.dim.x(), s.dim.y());
	}

}
