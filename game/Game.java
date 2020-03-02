package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	public Face face;
	
	public ArrayList<ArrayList<SquareNode>> board = new ArrayList<ArrayList<SquareNode>>();
	
	public Game() {
		this.face = new ConcFace(this);
		/*face.addActionListener('^', new ArrowListener('^', this));
		face.addActionListener('>', new ArrowListener('>', this));
		face.addActionListener('<', new ArrowListener('<', this));
		face.addActionListener('v', new ArrowListener('v', this));
		face.addActionListener(' ', new ArrowListener(' ', this));*/
		face.addActionListener('C', new ClearListener(this));
		//face.addActionListener('B', new ToggleBotListener(this));
		
		for (int i = 0; i < 4; i++) {
			board.add(new ArrayList<SquareNode>());
			for (int k = 0; k < 4; k++) {
				board.get(i).add(new SquareNode());
			}
		}
		//set a random 2 | 4 at a random index
		int i = (int)(Math.random() * board.size());
		int k = (int)(Math.random() * board.get(i).size());
		int i2 = i;
		int k2 = k;
		while (i2 == i && k2 == k) {
			i2 = (int)(Math.random() * board.size());
			k2 = (int)(Math.random() * board.get(i).size());
		}
		board.get(i).get(k).value = ((int)(Math.random() * 2 + 1)) * 2;
		board.get(i2).get(k2).value = ((int)(Math.random() * 2 + 1)) * 2;
		
		/*int current = 2;
		for (int i = 0; i < board.size(); i++)
			for (int k = 0; k < board.get(i).size() && (current <= 4096); k++) {
				board.get(i).get(k).value = current;
				current *= 2;
			}*/
		
		printBoard(0);
	}
	
	public void play(String direction) {
			go(direction);
			int i = (int)(Math.random() * board.size());
			int k = (int)(Math.random() * board.get(i).size());
			int count = 0;
			boolean possibleAdd = true;
			while (board.get(i).get(k).value != 0) {
				count++;
				i = (int)(Math.random() * board.size());
				k = (int)(Math.random() * board.get(i).size());
				if (count > 100) {
					possibleAdd = false;
					break;
				}
			}
			if (possibleAdd) {
				int toBePlaced = ((int)(Math.random() * 2 + 1)) * 2;
				board.get(i).get(k).value = toBePlaced;
			}
			int score = 0;
			for (int r = 0; r < board.size(); r++) {
				for (int c = 0; c < board.get(r).size(); c++) {
					score += board.get(r).get(c).value;
				}
			}
			printBoard(score);
	}
	
	private void go(String direction) {
		for (int q = 0; q < 3; q++) {//do 3 times
			if (direction.compareToIgnoreCase("w") == 0) {
				for (int i = 0; i < board.size(); i++) {
					for (int k = 0; k < board.get(i).size(); k++) {
						if (i+1 < board.size()) {
							if (board.get(i).get(k).value == board.get(i+1).get(k).value || board.get(i).get(k).value == 0 || 0 == board.get(i+1).get(k).value) {
								board.get(i).get(k).value += board.get(i+1).get(k).value;
								board.get(i+1).get(k).value = 0;
							}
						}
					}
				}
				//try {Thread.sleep(1000); printBoard(0);} catch (Exception e) {System.err.println(e.getMessage());}
			}
			else if (direction.compareToIgnoreCase("a") == 0) {
				for (int i = 0; i < board.size(); i++) {
					for (int k = 0; k < board.get(i).size(); k++) {
						if (k+1 < board.get(i).size()) {
							if (board.get(i).get(k).value == board.get(i).get(k+1).value || board.get(i).get(k).value == 0 || 0 == board.get(i).get(k+1).value) {
								board.get(i).get(k).value += board.get(i).get(k+1).value;
								board.get(i).get(k+1).value = 0;
							}
						}
					}
				}
				//try {Thread.sleep(1000); printBoard(0);} catch (Exception e) {System.err.println(e.getMessage());}
			}
			else if (direction.compareToIgnoreCase("d") == 0) {
				for (int i = board.size() - 1; i >= 0; i--) {
					for (int k = board.get(i).size() - 1; k >= 0; k--) {
						if (k-1 >= 0) {
							if (board.get(i).get(k).value == board.get(i).get(k-1).value || board.get(i).get(k).value == 0 || 0 == board.get(i).get(k-1).value) {
								board.get(i).get(k).value += board.get(i).get(k-1).value;
								board.get(i).get(k-1).value = 0;
							}
						}
					}
				}
				//try {Thread.sleep(1000); printBoard(0);} catch (Exception e) {System.err.println(e.getMessage());}
			}
			else if (direction.compareToIgnoreCase("s") == 0) {
				for (int i = board.size() - 1; i >= 0; i--) {
					for (int k = 0; k < board.get(i).size(); k++) {
						if (i-1 >= 0) {
							if (board.get(i).get(k).value == board.get(i-1).get(k).value || board.get(i).get(k).value == 0 || 0 == board.get(i-1).get(k).value) {
								board.get(i).get(k).value += board.get(i-1).get(k).value;
								board.get(i-1).get(k).value = 0;
							}
						}
					}
				}
				//try {Thread.sleep(1000); printBoard(0);} catch (Exception e) {System.err.println(e.getMessage());}
			}
			
		}
	}

	public void printBoard(int score) {
		face.writeToScreen(board, score);
	}

	public void clear() {
		board = new ArrayList<ArrayList<SquareNode>>();
		for (int i = 0; i < 4; i++) {
			board.add(new ArrayList<SquareNode>());
			for (int k = 0; k < 4; k++) {
				board.get(i).add(new SquareNode());
			}
		
		}
		int i = (int)(Math.random() * board.size());
		int k = (int)(Math.random() * board.get(i).size());
		int i2 = i;
		int k2 = k;
		while (i2 == i && k2 == k) {
			i2 = (int)(Math.random() * board.size());
			k2 = (int)(Math.random() * board.get(i).size());
		}
		board.get(i).get(k).value = ((int)(Math.random() * 2 + 1)) * 2;
		board.get(i2).get(k2).value = ((int)(Math.random() * 2 + 1)) * 2;
		printBoard(0);
		
	}
		
}
