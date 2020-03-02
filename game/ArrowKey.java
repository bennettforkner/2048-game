package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowKey implements KeyListener,ActionListener {
	
	private Game game;
	
	public ArrowKey(Game game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("Again");
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			game.play("w");
			//System.out.println("UP");
		} else if (code == KeyEvent.VK_DOWN) {
			game.play("s");
			//System.out.println("DOWN");
		} else if (code == KeyEvent.VK_LEFT) {
			game.play("a");
			//System.out.println("LEFT");
		} else if (code == KeyEvent.VK_RIGHT) {
			game.play("d");
			//System.out.println("RIGHT");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
