package pn.eu.firetrail.fugue.entity;

import pn.eu.firetrail.fugue.graphics.SpriteData;
import pn.eu.firetrail.fugue.utils.Vector2f;

public class NPC extends EntityLive {

	public boolean on_screen;
	public NPC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NPC(Vector2f pos, Vector2f vel, SpriteData sprite) {
		super(pos, vel, sprite);
		// TODO Auto-generated constructor stub
	}

	public NPC(Vector2f pos, Vector2f vel) {
		super(pos, vel);
		// TODO Auto-generated constructor stub
	}

	public NPC(Vector2f pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

}
