package pn.eu.firetrail.fugue;

import java.awt.Graphics;

import pn.eu.firetrail.fugue.entity.Entity;
import pn.eu.firetrail.fugue.graphics.SpriteSheet;

public class RenderSystem {
	
	public RenderSystem() {}

	public void draw(SpriteSheet ss, Graphics g) {
		for(Entity e : Game.getEntities(/*Stationary.class*/RenderSystem.class)) {
			
			g.drawImage(ss.getSprite(e.sprite), e.pos.x(), e.pos.y(), e.sprite.dim.x(), e.sprite.dim.y(), null);
		}
		/*for(Entity e : Game.getEntities(Character.class)) {
			g.drawImage(((EntityLive) e).anim.getCurrentSprite(e.sprite, ss, ((EntityLive) e).moving, ((EntityLive) e).direction), Math.round(e.pos.x), Math.round(e.pos.y), e.sprite.w, e.sprite.h, null);
		}*/
	}
}
