package game;


import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.*;




public class ConcFace implements Face {
	
    private static final int WINDOW_Y_POSITION = 0;
	private static final int WINDOW_X_POSITION = 0;
	private static final int WINDOW_HEIGHT = 600;
	private static final int WINDOW_WIDTH = 550;


	
	
	private JLabel[][] screen;
    private HashMap<Character, JButton> buttonMap;
    private JFrame window;
    private JPanel top = new JPanel();

    public ConcFace(Game g) {
    	
        buttonMap = new HashMap<Character, JButton>();
        window = new JFrame("2048");
        window.setFocusable(true);
        JPanel bottomNum = new JPanel();
        window.addKeyListener(new ArrowKey(g));
        JPanel realTop = new JPanel();
        
		realTop.setLayout(new GridLayout(1,3));
        JLabel a = new JLabel("2048");
        a.setBackground(new Color(228, 192, 42));
        a.setForeground(new Color(249, 246, 242));
        a.setFont(new Font("myFont",20,50));
        a.setOpaque(true);
        a.setSize(200, 200);
        realTop.add(a);
        
        JPanel b1 = new JPanel();
        b1.setLayout(new GridLayout(2,1));
        JLabel c = new JLabel("2048");
        c.setBackground(new Color(228, 192, 42));
        c.setForeground(new Color(249, 246, 242));
        c.setFont(new Font("myFont",20,50));
        c.setOpaque(true);
        c.setSize(200, 200);
        b1.add(c);
        JLabel d = new JLabel("2048");
        d.setBackground(new Color(228, 192, 42));
        d.setForeground(new Color(249, 246, 242));
        d.setFont(new Font("myFont",20,50));
        d.setOpaque(true);
        d.setSize(200, 200);
        b1.add(d);
        realTop.add(b1);
        
        

        bottomNum.setLayout(new GridLayout(4, 4));
        char[] labels = {'C', '.', '.', '.', '.', '.', '.', '^', '.', '.', '.', '<', ' ', '>', '.', '.', '.', 'v', '.', '.'};
        for (int i = 0; i < labels.length; i++) {
        	if (labels[i] != '.') {
	            JButton jbutt = new JButton("" + labels[i]);
	            jbutt.setOpaque(true);
	            jbutt.setBackground(new Color(203, 192, 180));
	            bottomNum.add(jbutt);
	            buttonMap.put(labels[i], jbutt);
        	}
        	else {
        		JLabel b = new JLabel();
        		b.setBackground(new Color(203, 192, 180));
        		b.setOpaque(true);
        		bottomNum.add(b);
        	}
        }
        bottomNum.setBorder(BorderFactory.createLineBorder(new Color(187, 174, 158),5,true));
        
        

       
        JPanel screenPanel = new JPanel();
        screenPanel.setLayout(new GridLayout(4, 4));
        screenPanel.setBorder(BorderFactory.createLineBorder(new Color(187, 174, 158), 7,true));
        screen = new JLabel[4][4];
        for (int i = 0; i < screen.length; i++) {
        	 for (int k = 0; k < screen[i].length; k++) {
	            screen[i][k] = new JLabel();
	            screen[i][k].setFont(new Font("myFont",20,50));
	            //screen[i][k].setEditable(false);
	            
	            screen[i][k].setOpaque(true);
	            screen[i][k].setSize(200, 200);
	            screen[i][k].setForeground(new Color(117, 110, 102));
	            screen[i][k].setBorder(BorderFactory.createLineBorder(new Color(187, 174, 158),7));
	            screenPanel.add(screen[i][k]);
        	 }
        }
        top.add(screenPanel);

        JPanel bottom = new JPanel();
        
        bottom.setLayout(new FlowLayout());
        bottom.add(bottomNum);

        Container contentPane = window.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(realTop,BorderLayout.NORTH);
        contentPane.add(top, BorderLayout.NORTH);
        //contentPane.add(bottom, BorderLayout.CENTER);
        window.setBackground(new Color(250, 248, 239));
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocation(WINDOW_X_POSITION, WINDOW_Y_POSITION);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void writeToScreen(ArrayList<ArrayList<SquareNode>> board, int score) {
    	ArrayList<Color> colors = new ArrayList<>();
    	colors.add(new Color(203, 192, 180));
    	colors.add(new Color(236, 228, 219));
    	colors.add(new Color(235, 223, 199));
    	colors.add(new Color(233, 178, 128));
    	colors.add(new Color(236, 141, 83));
    	colors.add(new Color(230, 132, 105));
    	colors.add(new Color(233, 88, 57));
    	colors.add(new Color(244, 216, 109));
    	colors.add(new Color(241, 208, 75));
    	colors.add(new Color(228, 192, 42));
    	colors.add(new Color(237, 197, 64));
    	colors.add(new Color(228, 192, 42));
    	colors.add(new Color(94, 218, 146));
    	
    	
        for (int i = 0; i < board.size(); i++) {
        	for (int k = 0; k < board.get(i).size(); k++) {
        		if (board.get(i).get(k).value != 0) {
        			if (board.get(i).get(k).value == 2)
        				screen[i][k].setBackground(colors.get(1));
					else if (board.get(i).get(k).value == 4)
						screen[i][k].setBackground(colors.get(2));
					else if (board.get(i).get(k).value == 8)
						screen[i][k].setBackground(colors.get(3));
					else if (board.get(i).get(k).value == 16)
						screen[i][k].setBackground(colors.get(4));
					else if (board.get(i).get(k).value == 32)
						screen[i][k].setBackground(colors.get(5));
					else if (board.get(i).get(k).value == 64)
						screen[i][k].setBackground(colors.get(6));
					else if (board.get(i).get(k).value == 128)
						screen[i][k].setBackground(colors.get(7));
					else if (board.get(i).get(k).value == 256)
						screen[i][k].setBackground(colors.get(8));
					else if (board.get(i).get(k).value == 512)
						screen[i][k].setBackground(colors.get(9));
					else if (board.get(i).get(k).value == 1024)
						screen[i][k].setBackground(colors.get(10));
					else if (board.get(i).get(k).value == 2048)
						screen[i][k].setBackground(colors.get(11));
					else
						screen[i][k].setBackground(colors.get(12));
        			
        			screen[i][k].setForeground(new Color(117, 110, 102));
        			if (board.get(i).get(k).value >= 8) {
        				screen[i][k].setForeground(new Color(249, 246, 242));
        			}
        			
        			
        			
        			if (board.get(i).get(k).value / 10 <= 0)
        				screen[i][k].setFont(new Font("Foop",20,75));
					else if (board.get(i).get(k).value / 100 <= 0)
						screen[i][k].setFont(new Font("Foop",20,50));
					else if (board.get(i).get(k).value / 1000 <= 0)
						screen[i][k].setFont(new Font("Foop",20,38));
					else if (board.get(i).get(k).value / 10000 <= 0)
						screen[i][k].setFont(new Font("Foop",20,30));
					else if (board.get(i).get(k).value / 100000 <= 0)
						screen[i][k].setFont(new Font("Foop",20,25));
        			screen[i][k].setText(" " + board.get(i).get(k).value + " ");
					
        		}
        		else {
        			screen[i][k].setBackground(colors.get(0));
        			screen[i][k].setText(" ");
        		}
        	}
        }
    }

   
	public void addActionListener(char button, ActionListener listener) {
		if (! buttonMap.containsKey(button))
			throw new NoSuchButtonException(button);
		buttonMap.get(button).addActionListener(listener);
	}

    public static void main(String[] args) {
        Game g1 = new Game();
        
    }

	
}

