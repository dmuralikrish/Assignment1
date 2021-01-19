/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 *
 * @author Shamima Nasrin Ali #201805363 
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;
    private Move movePlayer;
   

    /*
     * TBD: Create additional private members if useful.
     */
    public char playerSelection = 'X';
    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
        if(playerIsX == true) {
        	playerSelection = 'X';
        }
        else {
        	playerSelection = 'O';
        }
        if (challenging == true) {
        	//call the AI
        }
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
    	if (board.isFull() == false) {
    		return GameStatus.IN_PROGRESS;
    	}
    	
    }
    
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j) {
        if ((i >= 0 && i <= 2) && (j >= 0 && j <= 2)) {
        	movePlayer = new Move(i, j, playerSelection);
        	return true;
        }
        else {
        	return false;
        }
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
        ai.chooseMove(this.board);
    }
}
