package pn.eu.firetrail.fugue;

import pn.eu.firetrail.fugue.entity.Entity;

public class MovementSystem {
	
	public MovementSystem() {}
	public void update() {
		for(Entity e : Game.getEntities(Entity.class)) { e.pos.add(e.vel); }
	}
}
