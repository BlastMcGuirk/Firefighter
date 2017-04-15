package gameStates;

import game.Board;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class PauseState extends GameState {
	
	private Font font = new Font("Helvetica", Font.PLAIN, 70);

	public PauseState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		
	}

	public void update() {
		
	}

	public void draw(Graphics2D g) {
		FontMetrics fm = g.getFontMetrics(font);
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		
		g.drawString("PAUSED", (Board.WIDTH/2)-(fm.stringWidth("PAUSED")/2), (Board.HEIGHT/2));
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ESCAPE){
			gsm.unpause();
		}
	}

	public void keyReleased(int k) {
		
	}

}
