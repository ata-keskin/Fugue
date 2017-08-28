package pn.eu.firetrail.fugue.graphics;

import java.awt.image.BufferedImage;

public class Animation {
	private int current_frame = 1;
	private int frame_count;
	private int duration;
	private int clock = 0;
	
	public Animation(int frame_count, int duration) {
		this.frame_count = frame_count;
		this.duration = duration;
	}

	/*public void draw(SpriteData s, SpriteSheet ss, Graphics g, boolean m, char direction, Vector2f pos) {
		
		if(clock % duration == 0) {
			current_frame++;
			if(current_frame == frame_count+1) current_frame = 0;
		}
		clock++;
		if(m) {
			switch(direction) {
				case 'u':
					g.drawImage(ss.getSprite(new SpriteData(0+(current_frame*s.dim.igetX()), s.dim.igetY(), s.dim.igetX(), s.dim.igetY(), 0)), Math.round(pos.x), Math.round(pos.y), 40, 60, null);
					break;
				case 'd':
					g.drawImage(ss.getSprite(new SpriteData(0+(current_frame*s.dim.igetX()), s.dim.igetY()*2, s.dim.igetX(), s.dim.igetY(), 0)), Math.round(pos.x), Math.round(pos.y), 40, 60, null);
					break;
				case 'r':
					g.drawImage(ss.getSprite(new SpriteData(s.dim.igetX()*2+(current_frame*s.dim.igetX()), s.dim.igetY(), s.dim.igetX(), s.dim.igetY(), 0)), Math.round(pos.x), Math.round(pos.y), 40, 60, null);
					break;
				case 'l':
					g.drawImage(ss.getSprite(new SpriteData(s.dim.igetX()*2+(current_frame*s.dim.igetX()), s.dim.igetY()*2, s.dim.igetX(), s.dim.igetY(), 0)), Math.round(pos.x), Math.round(pos.y), 40, 60, null);
					break;
			}
		}
		else {
			switch(direction) {
				case 'u':
					g.drawImage(ss.getSprite(new SpriteData(0, 0, s.dim.igetX(), s.dim.igetY(), 0)), Math.round(pos.x), Math.round(pos.y), 40, 60, null);
					break;
				case 'd':
					g.drawImage(ss.getSprite(new SpriteData(s.dim.igetX()*2, 0, s.dim.igetX(), s.dim.igetY(), 0)), Math.round(pos.x), Math.round(pos.y), 40, 60, null);
					break;
				case 'r':
					g.drawImage(ss.getSprite(new SpriteData(s.dim.igetX(), 0, s.dim.igetX(), s.dim.igetY(), 0)), Math.round(pos.x), Math.round(pos.y), 40, 60, null);
					break;
				case 'l':
					g.drawImage(ss.getSprite(new SpriteData(s.dim.igetX()*3, 0, s.dim.igetX(), s.dim.igetY(), 0)), Math.round(pos.x), Math.round(pos.y), 40, 60, null);
					break;
		}
		}
	}*/
	
public BufferedImage getCurrentSprite(SpriteData s, SpriteSheet ss, boolean m, char direction) {
		if(clock % duration == 0) {
			current_frame++;
			if(current_frame == frame_count+1) current_frame = 0;
		}
		clock++;
		
		if(m) {
			switch(direction) {
				case 'u':
					return ss.getSprite(new SpriteData(0+(current_frame*s.dim.x()), s.dim.y(), s.dim.x(), s.dim.y(), 0));
				case 'd':
					return ss.getSprite(new SpriteData(0+(current_frame*s.dim.x()), s.dim.y()*2, s.dim.x(), s.dim.y(), 0));
				case 'r':
					return ss.getSprite(new SpriteData(s.dim.x()*2+(current_frame*s.dim.x()), s.dim.y(), s.dim.x(), s.dim.y(), 0));
				case 'l':
					return ss.getSprite(new SpriteData(s.dim.x()*2+(current_frame*s.dim.x()), s.dim.y()*2, s.dim.x(), s.dim.y(), 0));
			}
		}
		else {
			switch(direction) {
				case 'u':
					return ss.getSprite(new SpriteData(0, 0, s.dim.x(), s.dim.y(), 0));
				case 'd':
					return ss.getSprite(new SpriteData(s.dim.x()*2, 0, s.dim.x(), s.dim.y(), 0));
				case 'r':
					return ss.getSprite(new SpriteData(s.dim.x(), 0, s.dim.x(), s.dim.y(), 0));
				case 'l':
					return ss.getSprite(new SpriteData(s.dim.x()*3, 0, s.dim.x(), s.dim.y(), 0));
			}
		}
		
		return null;
	}
}
