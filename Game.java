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
    public char playerSelection = ' ';
    private char winningChar = ' ';
    private DumbAI dumbAI;
    private SmartAI smartAI;
    private Move moveAI;

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
        if(playerIsX == true && challenging == true) {
        	this.playerSelection = 'X';
        	this.smartAI = new SmartAI(true);
        }
        else if (playerIsX == true && challenging == false) {
        	this.playerSelection = 'X';
        	this.dumbAI = new DumbAI(false);
        }
        else if (playerIsX == false && challenging == true) {
        	this.playerSelection = 'O';
        	this.smartAI = new SmartAI(true);
        }
        else if (playerIsX == false && challenging == false) {
        //quit	
        }
        
        
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
    	if (board.isFull() == true && CheckForWinner() != 'X' && CheckForWinner() != 'O') {
    		status = GameStatus.DRAW;
    		return  status;
    	}
    	
    	else if (board.isFull() == false && CheckForWinner() == 'X') {
    		status = GameStatus.X_WON;
    		return status ;
    	}
    	
    	else if (board.isFull() == false && CheckForWinner() == 'O') {
    		status = GameStatus.O_WON;
    		return status; 
    	}
    	else {
	    	status = GameStatus.IN_PROGRESS;
	    	return status;
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
        	this.board = new Board(this.board, movePlayer);
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
    	//need logic to choose b/w smart and dumb  aiiii		
    		moveAI = dumbAI.chooseMove(this.board);
    		this.board= new Board(this.board, moveAI);
    }

    
    public char CheckForWinner() {
    	if (this.board.isFull() == false) {
    		return ' ';
    	}
    	else {
	    	//checks horizontally
	    	for(int j = 0; j <3; j++) {
	    		if ((board.get(0, j) == board.get(1, j)) && 
	    			(board.get(1, j) == board.get(2, j)) && 
	    			(board.get(2, j) == board.get(0, j))) {
	    			 winningChar = board.get(0, j);
	    		}
	    	}
	    			 
	    	//determines who won.
			 if (winningChar == playerSelection && winningChar!= ' ') {
				 System.out.print("You won!");
			 }
				 
			 else {
				 System.out.print("Loser!");
			} 				  
	    	
			 //helps to set the game status
			 if (winningChar == 'X') {
				 return 'X';
			 }
			 else {
				 return 'O';
			 }	
    	}
    }
      
    
    }
    
    
    
    
    
 


    
    
    
    
    
    

