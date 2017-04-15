package gameStates;

import graphics.Background;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Entity.Fire;
import Entity.FireFighter;

public class PlayState extends GameState {
	
	private Background bg;
	
	private long timer;
	private long start;
	
	private Point[] fireSpots = {
		new Point(40, 32),
		new Point(140, 32),
		new Point(245, 32),
		new Point(40, 96),
		new Point(120, 121),
		new Point(162, 121),
		new Point(245, 96)
	};
	private boolean[] fireUsed = {
		false,
		false,
		false,
		false,
		false,
		false,
		false
	};
	
	private double healthTotal;
	private final double healthMax = 100;
	private final double healthRate = .025;
	
	private ArrayList<Fire> fires;
	
	private FireFighter ff;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	public void init() {
		bg = new Background("/Building.png");
		fires = new ArrayList<Fire>();
		ff = new FireFighter();
		timer = System.currentTimeMillis();
		start = System.currentTimeMillis();
		healthTotal = healthMax;
	}
	
	private void addFires(){
		if (System.currentTimeMillis() - timer > 700){
			boolean goOn = false;
			for (boolean b : fireUsed){
				if (b == false)
					goOn = true;
			}
			if (goOn){
				int num = (int) (Math.random() * fireSpots.length);
				while (fireUsed[num] == true){
					num = (int) (Math.random() * fireSpots.length);
				}
				fires.add(new Fire(fireSpots[num]));
				fireUsed[num] = true;
			}
			timer = System.currentTimeMillis();
		}
	}
	private void doDamage(){
		int multi = 0;
		for (boolean b : fireUsed){
			if (b) multi++;
		}
		healthTotal -= (multi * healthRate);
	}
	
	public void update() {
		bg.update();
		addFires();
		for (Fire f : fires){
			f.update();
		}
		ff.update();
		doDamage();
		
		if (healthTotal < 0){
			gsm.setState(GameStateManager.GAMEOVERSTATE);
		}
	}

	public void draw(Graphics2D g) {
		bg.draw(g);
		for (Fire f : fires){
			g.drawImage(f.getImage(), f.getX(), f.getY(), null);
		}
		g.drawImage(ff.getImage(), ff.getX(), ff.getY(), null);
		g.drawImage(ff.getSelector().getImage(), ff.getSelector().getX(), ff.getSelector().getY(), null);
		if (ff.isWatering()){
			g.drawImage(ff.getWater().getImage(), ff.getWater().getX(), ff.getWater().getY(), null);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.PLAIN, 14));
		g.drawString("HEALTH: " + (int)healthTotal, 40, 15);
		g.drawString("SECONDS: " + (int) ((System.currentTimeMillis() - start) / 1000), 140, 15);
	}
	
	public void subtractTime(long tim){
		timer = System.currentTimeMillis();
		start = start + (tim-start);
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ESCAPE){
			gsm.setTime(System.currentTimeMillis());
			gsm.pause();
		}
		ff.keyPressed(k);
		if (k == KeyEvent.VK_SPACE){
			for (int i = 0; i < fires.size(); i++){
				if (fires.get(i).getX()-2 == ff.getPoint()[ff.getSelected()].x && fires.get(i).getY()-2 == ff.getPoint()[ff.getSelected()].y){
					fires.remove(i);
					i--;
					fireUsed[ff.getSelected()] = false;
				}
			}
		}
	}

	public void keyReleased(int k) {
		
	}

}
