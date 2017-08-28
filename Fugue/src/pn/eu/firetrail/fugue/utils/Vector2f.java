package pn.eu.firetrail.fugue.utils;

public class Vector2f {
	public float x, y;
	
	public Vector2f() { x = 0; y = 0; }

	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(Vector2f v) {
		this.x += v.x;
		this.y += v.y;
	}
	
	public int x() { return Math.round(x); }
	public int y() { return Math.round(y); }
	
	@Override 
	public String toString() {
		return "X: " + x + " Y: " + y;
	}
}
