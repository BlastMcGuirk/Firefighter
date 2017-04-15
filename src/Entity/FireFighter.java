package Entity;

import game.Board;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FireFighter {

	private BufferedImage image;
	
	private boolean watering;
	private long timer;
	
	private int x, y;
	
	private Point[] pos = {
		new Point(60, Board.HEIGHT-50),
		new Point(120, Board.HEIGHT-50),
		new Point(180, Board.HEIGHT-50)
	};
	private Point[] Wpos = {
		new Point(60 + 29, Board.HEIGHT-70),
		new Point(120 + 29, Board.HEIGHT-70),
		new Point(180 + 29, Board.HEIGHT-70)
	};
	
	private Point[] point = {
		new Point(38, 30),
		new Point(138, 30),
		new Point(243, 30),
		
		new Point(38, 94),
		new Point(118, 119),
		new Point(160, 119),
		new Point(243, 94)
	};
	
	private int currentPoint, currentPos;
	
	private Selector select;
	private Water water;
	
	public FireFighter(){
		select = new Selector(point[1]);
		water = new Water(pos[1]);
		currentPos = 1;
		currentPoint = 1;
		
		watering = false;
		
		this.x = pos[currentPos].x;
		this.y = pos[currentPos].y;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/FireFighter.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getSelected(){
		return currentPoint;
	}
	
	public Selector getSelector(){
		return select;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public Point[] getPoint(){
		return point;
	}
	
	public void keyPressed(int k){
		if (k == KeyEvent.VK_SPACE){
			watering = true;
			timer = System.currentTimeMillis();
		}
		
		if (k == KeyEvent.VK_RIGHT){
			if (currentPoint == 0)
				currentPoint = 1;
			else if (currentPoint == 1)
				currentPoint = 2;
			else if (currentPoint == 3)
				currentPoint = 4;
			else if (currentPoint == 4)
				currentPoint = 5;
			else if (currentPoint == 5)
				currentPoint = 6;
		}
		else if (k == KeyEvent.VK_LEFT){
			if (currentPoint == 1)
				currentPoint = 0;
			else if (currentPoint == 2)
				currentPoint = 1;
			else if (currentPoint == 4)
				currentPoint = 3;
			else if (currentPoint == 5)
				currentPoint = 4;
			else if (currentPoint == 6)
				currentPoint = 5;
		}
		else if (k == KeyEvent.VK_UP){
			if (currentPoint == 3)
				currentPoint = 0;
			else if (currentPoint == 4)
				currentPoint = 1;
			else if (currentPoint == 5)
				currentPoint = 1;
			else if (currentPoint == 6)
				currentPoint = 2;
		}
		else if (k == KeyEvent.VK_DOWN){
			if (currentPoint == 0)
				currentPoint = 3;
			else if (currentPoint == 1)
				currentPoint = 4;
			else if (currentPoint == 2)
				currentPoint = 6;
		}
		
		select.setPoint(point[currentPoint]);
		
		if (point[currentPoint].x < 50){
			currentPos = 0;
		}
		else if (point[currentPoint].x > 220){
			currentPos = 2;
		}
		else currentPos = 1;
		
		this.x = pos[currentPos].x;
		this.y = pos[currentPos].y;
		
		water.setPoint(Wpos[currentPos]);
		
	}
	
	public Water getWater(){
		return water;
	}
	
	public boolean isWatering(){
		return watering;
	}
	
	public void update(){
		if (watering){
			if (System.currentTimeMillis() - timer > 500){
				watering = false;
			}
		}
	}
	
}
