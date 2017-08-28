package pn.eu.firetrail.fugue.entity;

import pn.eu.firetrail.fugue.graphics.Animation;
import pn.eu.firetrail.fugue.graphics.SpriteData;
import pn.eu.firetrail.fugue.utils.Vector2f;

public class EntityLive extends Entity {
	
	public boolean moving;
	public char direction;
	public Animation anim;
	
	public EntityLive() { direction = 'd'; }
	public EntityLive(Vector2f pos) { super(pos); direction = 'd'; }
	public EntityLive(Vector2f pos, Vector2f vel) { super(pos, vel); direction = 'd'; }
	public EntityLive(Vector2f pos, Vector2f vel, SpriteData sprite) { super(pos, vel, sprite); direction = 'd'; }

}
