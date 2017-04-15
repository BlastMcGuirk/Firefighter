package gameStates;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {
	
	private ArrayList<GameState> gameStates;
	private int currentState;
	
	private long timer;
	
	public static final int MENUSTATE = 0;
	public static final int HELPSTATE = 1;
	public static final int ABOUTSTATE = 2;
	public static final int PLAYSTATE = 3;
	public static final int PAUSESTATE = 4;
	public static final int GAMEOVERSTATE = 5;
	
	public GameStateManager(){
		gameStates = new ArrayList<GameState>();
		
		//ADD THE STATES HERE!!! ADD AS YOU FINISH!!!
		gameStates.add(new MenuState(this));
		gameStates.add(new HelpState(this));
		gameStates.add(new AboutState(this));
		gameStates.add(new PlayState(this));
		gameStates.add(new PauseState(this));
		gameStates.add(new GameOverState(this));
		
		currentState = MENUSTATE;
	}
	
	public void setState(int state){
		currentState = state;
		init();
	}
	
	public void setTime(long tim){
		timer = tim;
	}
	public long getTime(){
		return timer;
	}
	
	public void pause(){
		currentState = PAUSESTATE;
	}
	public void unpause(){
		currentState = PLAYSTATE;
		((PlayState) gameStates.get(PLAYSTATE)).subtractTime(timer);
	}
	
	public void init(){
		gameStates.get(currentState).init();
	}
	public void update(){
		gameStates.get(currentState).update();
	}
	public void draw(Graphics2D g){
		gameStates.get(currentState).draw(g);
	}
	public void keyPressed(int k){
		gameStates.get(currentState).keyPressed(k);
	}
	public void keyReleased(int k){
		gameStates.get(currentState).keyReleased(k);
	}

}
