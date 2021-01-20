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
    private bool isThereAWinner = false;

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
    	CheckForWinner();
	if (board.isFull() == true && isThereAWinner == false) {
    		status = GameStatus.DRAW;
    		return  status;
    	}
    	
    	else if (isThereAWinner == true && CheckForWinner == 'X') {
    		status = GameStatus.X_WON;
    		return status ;
    	}
    	
    	else if (isThereAWinner == true && CheckForWinner() == 'O') {
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
	//checks horizontally
	 for(int j = 0; j <3; j++) {
	 	if ((board.get(0, j) == board.get(1, j)) && (board.get(1, j) == board.get(2, j)) && (board.get(2, j) == board.get(0, j))) {
	    		winningChar = board.get(0, j);
			isThereAWinner = true;
	    	}
	 }
	//checks vertically
	for(int i = 0; i <3; i++) {
		if ((board.get(i, 0) == board.get(i, 1)) && (board.get(i, 1) == board.get(i, 2)) && (board.get(i, 2) == board.get(i,0))) {
			winningChar = board.get(i, 0);
			isThereAWinner = true;
		}
	}
		
	//checks right diagonal
	if (board.get(0,0) == board.get(1, 1) && board.get(1, 1) == board.get(2,2){
		winningChar = board.get(1, 1);
		isThereAWinner = true;
	}
		    
	//checks left diagonal
	if (board.get(0,2) == board.get(1, 1) && board.get(1, 1) == board.get(2,0){
		winningChar = board.get(1, 1);
		isThereAWinner = true;
	}		    
	    			 
   	//determines who won.
	if (winningChar == playerSelection && isThereAWinner == true) {
		System.out.print("You won!");
	}
				 
	else if (winningChar != playerSelection && isThereAWinner == true){
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
    
    
    
    
    
 


    
    
    
    
    
    

