package Entity;

import graphics.Animation;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fire {
	
	private Animation anim;
	
	private final int WIDTH = 40, HEIGHT = 40;
	
	private int x, y;
	
	public Fire(Point p){
		this.x = p.x;
		this.y = p.y;
		
		try {
			BufferedImage fire = ImageIO.read(getClass().getResourceAsStream("/FireSheet.png"));
			BufferedImage[] fires = new BufferedImage[fire.getWidth()/WIDTH];
			for (int i = 0; i < fire.getWidth()/WIDTH; i++){
				BufferedImage bi = fire.getSubimage(i * WIDTH, 0, WIDTH, HEIGHT);
				fires[i] = bi;
			}
			
			anim = new Animation();
			anim.setDelay(150);
			anim.setImages(fires);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(){
		anim.update();
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public BufferedImage getImage(){
		return anim.getImage();
	}
	
}
