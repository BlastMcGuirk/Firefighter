package gameStates;

import game.Board;
import graphics.Background;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class AboutState extends GameState {

	private Background bg;
	
	private String[] abouts = {
		"Fire Rescue Squad:",
		"  ",
		"Idea by: Brendan McGuirk",
		"Coded by: Brendan McGuirk (Java)",
		"Art by: Brendan McGuirk (Paint.NET)",
		"Tested by: Brendan McGuirk",
		"Sorry there's no music!",
		"  ",
		"(Enter to continue...)"
	};
	
	private Font font = new Font("Helvetica", Font.PLAIN, 18);
	
	public AboutState(GameStateManager gsm) {
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
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		
		for (int i = 0; i < abouts.length; i++){
			g.drawString(abouts[i], (Board.WIDTH/2)-(fm.stringWidth(abouts[i])/2), 40 + (i * (font.getSize() + 3)));
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
