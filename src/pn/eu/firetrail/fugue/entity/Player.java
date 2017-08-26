package pn.eu.firetrail.fugue.entity;

import pn.eu.firetrail.fugue.graphics.Animation;
import pn.eu.firetrail.fugue.graphics.SpriteData;
import pn.eu.firetrail.fugue.utils.Vector2f;

public class Player extends EntityLive{
	
	public Player() {
		super(new Vector2f(), new Vector2f(3f, 2.5f), new SpriteData(0, 0, 40, 64, 32, 0));
		anim = new Animation(1, 12);
	}
}
