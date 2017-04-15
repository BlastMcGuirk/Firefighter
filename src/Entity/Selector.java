package Entity;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Selector {
	
	private BufferedImage image;
	
	private int x, y;
	
	public Selector(Point p){
		x = p.x;
		y = p.y;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Selection.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPoint(Point p){
		x = p.x;
		y = p.y;
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
	public Point getPoint(){
		return new Point(x, y);
	}

}
