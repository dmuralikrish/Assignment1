/**
 * Realization of AI interface using simplistic random placement strategy.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

import java.util.Random;

public class DumbAI implements AI {
    
    private Random random = new Random();

    /*
     * TBD: Create additional private members if useful.
     */
    private Game game;
    char aiSelection = 'O';
    private int xAI;
    private int yAI;
    private Move move;
    /**
     * Construct a DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) {
        /*
         * TBD
         */
    	if (game.playerSelection == 'X') {
    		aiSelection = 'O';
    	}
    	else {
    		aiSelection = 'X';
    	}
    }

    public Move chooseMove(Board board) {
        /*
         * TBD
         */
    	xAI = random.nextInt(3);
    	yAI = random.nextInt(3);
    	while(board.get(xAI, yAI) != ' ') {
    		xAI = random.nextInt(3);
        	yAI = random.nextInt(3);
    	}
    	move = new Move(xAI, yAI, aiSelection);  		
    	return move; 
    }
}
