package pn.eu.firetrail.fugue;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import pn.eu.firetrail.fugue.entity.Entity;
import pn.eu.firetrail.fugue.graphics.Display;
import pn.eu.firetrail.fugue.graphics.SpriteSheet;
import pn.eu.firetrail.fugue.utils.KeyManager;

public class Game implements Runnable {
	
	private Display display;
	
	private boolean running = false;
	private Thread thread;
	
	private static ArrayList<Entity> entities;
	
	private RenderSystem rs;
	private static State current_state;
	
	private BufferStrategy bs;
	private static KeyManager km;
	private Graphics graphics;
	
	private static SpriteSheet ss;
	
	
	public static int width = 1024, height = width * 3/5;  // 1024/576 - 1280/768
	public static float tileWidth = width / 20;
	public Game() {}
	
	private void init() {
		display = new Display("v0.0.1", width, height);
		km = new KeyManager();
		entities = new ArrayList<Entity>();
		current_state = new GameState();
		rs = new RenderSystem();

		
		display.getJFrame().addKeyListener(km);
		ss = new SpriteSheet(new String[] {"/textures/player.png"});
	}
	
	private void update(float delta) {
		current_state.update();
	}
	
	private void draw() {
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		graphics = bs.getDrawGraphics();
		graphics.fillRect(0, 0, width, height);
		//
		current_state.draw(rs, ss, graphics);
		//
		bs.show();
		graphics.dispose();
		
	}
	
	public static ArrayList<Entity> getEntities(Class<?> c) {
		if(c.equals(Entity.class)) return entities;
		ArrayList<Entity> temp = new ArrayList<Entity>();
		for(int i = 0; i > entities.size(); i++) {
			if(entities.get(i).getClass().equals(c)) {
				temp.add(entities.get(i));
			}
		}
		return temp;
	}
	
	public static KeyManager getKeyManager() {
		return km;
	}
	
	public static SpriteSheet getSS() {
		return ss;
	}
	

	@Override
	public void run() {
		
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			if(delta >=1) {
				update((float) delta);
				draw();
				delta--;
			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		if(!running) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public synchronized void stop() {
		if(running) {
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
