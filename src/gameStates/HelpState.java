package gameStates;

import game.Board;
import graphics.Background;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class HelpState extends GameState {

	private Background bg;
	
	private String[] helps = {
		"You are a firefighter. Don't let the building burn.",
		"You press space to fire water from your hose.",
		"The house has a certain amount of health.",
		"Fire runs the health down.",
		"The goal is to last as long as you can.",
		"Use the arrow keys to select a part of the building.",
		"Good luck, hero.",
		"  ",
		"(Enter to continue...)"
	};
	
	private Font font = new Font("Helvetica", Font.PLAIN, 14);
	
	public HelpState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	public void init() {
		bg = new Background("/Title.png");
	}

	public void update() {
		bg.update();
	}

	public void draw(Graphics2D g) {
		bg.draw(g);
		
		FontMetrics fm = g.getFontMetrics(font);
		
		g.setFont(font);
		g.setColor(Color.WHITE);
		
		for (int i = 0; i < helps.length; i++){
			g.drawString(helps[i], (Board.WIDTH/2) - (fm.stringWidth(helps[i])/2), 50 + (i * (font.getSize() + 3)));
		}
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER){
			gsm.setState(GameStateManager.MENUSTATE);
		}
	}

	public void keyReleased(int k) {
		
	}

}
