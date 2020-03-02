package game;
import java.util.ArrayList;

/**
 * CalculatorFace.java
 *
 * Interface CalculatorFace to define how the 
 *
 * @author Thomas VanDrunen
 * CS 245, Wheaton College
 * Original: Jan 19 2007
 * Redone: June 27, 2014
 */

import java.awt.event.ActionListener;

public interface Face {

    /**
     * Print a string to the screen portion of the game UI.
     * @param score 
     * @param display The String to be displayed.
     */
    public void writeToScreen(ArrayList<ArrayList<SquareNode>> board, int score);
    
    public void addActionListener(char button, ActionListener listener);
    
}
