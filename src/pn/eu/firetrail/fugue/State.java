package pn.eu.firetrail.fugue;

import java.awt.Graphics;

import pn.eu.firetrail.fugue.graphics.SpriteSheet;

public abstract class State {
	
	public State() {}
	public abstract void update();
	public abstract void draw(RenderSystem rs, SpriteSheet ss, Graphics graphics);
}
