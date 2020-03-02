package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrowListener implements ActionListener {
	private char direction;
	private Game game;
	
	public ArrowListener(char direction, Game game) {
		this.direction = direction;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (direction == '^')
			game.play("w");
		else if (direction == '<')
			game.play("a");
		else if (direction == 'v')
			game.play("s");
		else if (direction == '>')
			game.play("d");
	}
	
}