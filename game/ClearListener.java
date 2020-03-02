package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener {
	
	private Game game;
	public ClearListener(Game g) {
		this.game = g;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		game.clear();
	}

}
