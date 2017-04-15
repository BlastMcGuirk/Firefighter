package gameStates;

import game.Board;
import graphics.Background;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

	private Background bg;
	
	private String title = "Fire Rescue Squad";
	private Font TFont = new Font("Helvetica", Font.PLAIN, 35);
	private String[] options = {"Play","Help","About","Quit"};
	private Font OFont = new Font("Helvetica", Font.PLAIN, 20);
	private int choice = 0;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	public void init() {
		bg = new Background("/Title.png");
		choice = 0;
	}

	public void update() {
		bg.update();
	}

	public void draw(Graphics2D g) {
		bg.draw(g);
		
		FontMetrics TitFM = g.getFontMetrics(TFont);
		FontMetrics OptFM = g.getFontMetrics(OFont);
		
		g.setColor(Color.WHITE);
		g.setFont(TFont);
		g.drawString(title, (Board.WIDTH/2) - (TitFM.stringWidth(title)/2), 60);
		g.setFont(OFont);
		for (int i = 0; i < options.length; i++){
			g.setColor(Color.WHITE);
			if (i == choice) g.setColor(Color.BLUE);
			g.drawString(options[i], (Board.WIDTH/2) - (OptFM.stringWidth(options[i])/2), 120 + (i * (OFont.getSize() + 3)));
		}
	}
	
	private void select(){
		if (choice == 0){
			gsm.setState(GameStateManager.PLAYSTATE);
		}
		if (choice == 1){
			gsm.setState(GameStateManager.HELPSTATE);
		}
		if (choice == 2){
			gsm.setState(GameStateManager.ABOUTSTATE);
		}
		if (choice == 3){
			System.exit(0);
		}
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_UP){
			choice--;
			if (choice < 0){
				choice = options.length-1;
			}
		}
		if (k == KeyEvent.VK_DOWN){
			choice++;
			if (choice > options.length-1){
				choice = 0;
			}
		}
		if (k == KeyEvent.VK_ENTER){
			select();
		}
	}

	public void keyReleased(int k) {
		
	}

}
