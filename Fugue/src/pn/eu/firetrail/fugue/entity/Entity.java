package pn.eu.firetrail.fugue.entity;

import pn.eu.firetrail.fugue.Game;
import pn.eu.firetrail.fugue.graphics.SpriteData;
import pn.eu.firetrail.fugue.utils.Vector2f;

public class Entity {
	public Vector2f pos;
	public Vector2f vel;
	public SpriteData sprite;

	public Entity() {this.pos = new Vector2f();	this.vel = new Vector2f();}
	public Entity(Vector2f pos) { this.pos = pos; this.vel = new Vector2f();}
	public Entity(Vector2f pos, Vector2f vel) {	this.pos = pos;	this.vel = new Vector2f((Game.tileWidth*vel.x)/60, (Game.tileWidth*vel.y)/60); }
	public Entity(Vector2f pos, Vector2f vel, SpriteData sprite) {	this.pos = pos;	this.vel = new Vector2f((Game.tileWidth*vel.x)/60, (Game.tileWidth*vel.y)/60); this.sprite = sprite;}
}
