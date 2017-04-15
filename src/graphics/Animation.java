package graphics;

import java.awt.image.BufferedImage;

public class Animation {
	
	private BufferedImage[] images;
	private boolean playedOnce;
	private int current;
	
	private long start, delay;
	
	public Animation(){
		playedOnce = false;
	}
	
	public void setImages(BufferedImage[] img){
		images = img;
		current = 0;
		playedOnce = false;
		start = System.nanoTime();
	}
	
	public void setDelay(long d){delay = d;}
	public void setFrame(int f){current = f;}
	
	public void update(){
		if(delay == -1) return;
		
		long elapsed = (System.nanoTime() - start) / 1000000;
		if(elapsed > delay) {
			current++;
			start = System.nanoTime();
		}
		if(current == images.length) {
			current = 0;
			playedOnce = true;
		}
	}
	
	public int getFrame() { return current; }
	public BufferedImage getImage() { return images[current]; }
	public boolean hasPlayedOnce() { return playedOnce; }

}
