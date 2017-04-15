package gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class GameOverState extends GameState {

	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		
	}

	public void update() {
		
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.PLAIN, 16));
		g.drawString("GAME OVER (Enter to continue...)", 30, 180);
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER){
			gsm.setState(GameStateManager.MENUSTATE);
		}
	}

	public void keyReleased(int k) {
		
	}

}
