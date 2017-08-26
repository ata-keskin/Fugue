package pn.eu.firetrail.fugue.graphics;

import pn.eu.firetrail.fugue.Game;
import pn.eu.firetrail.fugue.utils.Vector2f;

public class SpriteData {
	
	public int sprite_sheet;
	public Vector2f dim, sheet_pos, draw_dim; // if float d is given as 32 then the sprite width is equal to one cell
	
	public SpriteData(Vector2f dim, Vector2f sheet_pos, Vector2f draw_dim, int sprite_sheet) {
		this.dim = dim;
		this.sheet_pos = sheet_pos;
		this.draw_dim = draw_dim;
		this.sprite_sheet = sprite_sheet;
	}
	
	public SpriteData(int x, int y, float w, float h, float d, int sprite_sheet) {
		this.dim = new Vector2f(w, h);
		this.sheet_pos = new Vector2f(x, y);
		this.draw_dim = new Vector2f(Game.tileWidth * (d/32) , Game.tileWidth * (dim.y / dim.x * (d/32)));
		this.sprite_sheet = sprite_sheet;
	}
	
	public SpriteData(int x, int y, float w, float h, int sprite_sheet) {
		this.dim = new Vector2f(w, h);
		this.sheet_pos = new Vector2f(x, y);
		this.sprite_sheet = sprite_sheet;
	}
	
}
