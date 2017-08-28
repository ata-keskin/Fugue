package pn.eu.firetrail.fugue;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import pn.eu.firetrail.fugue.entity.Entity;
import pn.eu.firetrail.fugue.entity.EntityLive;
import pn.eu.firetrail.fugue.entity.NPC;
import pn.eu.firetrail.fugue.entity.Player;
import pn.eu.firetrail.fugue.graphics.SpriteSheet;
import pn.eu.firetrail.fugue.utils.Utils;
import pn.eu.firetrail.fugue.utils.Vector2f;

public class GameState extends State {
	
	private Player player;
	private Vector2f p;
	private Vector2f v;
	
	public GameState() {
		player = new Player();
		p = player.pos;
		v = player.vel;
		Game.getEntities(Entity.class).add(player);
	}
	
	@Override
	public void update() {
		if(Utils.doEverySecond(1, 60)) System.out.println(Utils.getTileCoor(player.pos).toString());
		//STANDARD_MOTION
		for(Entity e : Game.getEntities(NPC.class)) { e.pos.add(e.vel);	}
		
		//PLAYER_MOTION
		player.moving = false;
		if(Game.getKeyManager().getKey(KeyEvent.VK_RIGHT)) { p.x += v.x; player.direction = 'r'; player.moving = true; }
		if(Game.getKeyManager().getKey(KeyEvent.VK_LEFT)) { p.x -= v.x;  player.direction = 'l'; player.moving = true; }
		if(Game.getKeyManager().getKey(KeyEvent.VK_DOWN)) { p.y += v.y;  player.direction = 'd'; player.moving = true; }
		if(Game.getKeyManager().getKey(KeyEvent.VK_UP)) { p.y -= v.y;  player.direction = 'u'; player.moving = true; }
		
	}

	@Override
	public void draw(RenderSystem rs, SpriteSheet ss, Graphics graphics) {
		//DRAW PLAYER
		graphics.drawImage(player.anim.getCurrentSprite(player.sprite, ss, player.moving, player.direction), player.pos.x(), player.pos.y(), player.sprite.draw_dim.x(), player.sprite.draw_dim.y(), null);
		Utils.drawDebugGrid(graphics);
		//DRAW LIVE ENTITIES
		for(Entity e : Game.getEntities(EntityLive.class)) {
			System.out.println("called");
			graphics.drawImage(((EntityLive) e).anim.getCurrentSprite(e.sprite, ss, ((EntityLive) e).moving, ((EntityLive) e).direction), e.pos.x(), e.pos.y(), e.sprite.dim.x(), e.sprite.dim.y(), null);
		}
		//DRAW ALL ELSE
		rs.draw(ss, graphics);
	}
	
}
