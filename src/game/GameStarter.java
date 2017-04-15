package game;

import javax.swing.JFrame;

public class GameStarter {

	public static void main(String[] args) {

		JFrame f = new JFrame("Fire Rescue Squad");
		f.setContentPane(new Board());
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

}
