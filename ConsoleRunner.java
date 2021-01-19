/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

import java.util.Scanner;

public class ConsoleRunner {

    /**
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX;

    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);
    

    /*
     * TBD: Create additional private members if useful.
     */
    String userResponseX;
    String userResponseChallenge;
    
    int userXChoice;
    int userYChoice;
    
    private boolean challenging;
    
    Board board = new Board();
    Move move;
    
    private boolean gameInProgress = true;
    private char winningChar = ' ';
    
    /**
     * Constructor
     */
    public ConsoleRunner() {    
        /*
         * TBD
         *
         * Use the 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */
    	
    	System.out.print("Do you want to play as X (Y/N): ");  
    	userResponseX = scanner.nextLine();  
    	System.out.print("Do you want a challenge (Y/N): ");  
    	userResponseChallenge = scanner.nextLine();  
    	this.playerIsX = userResponseX.matches("Y");
    	this.challenging = userResponseChallenge.matches("Y");
    	game = new Game(playerIsX, challenging);
    	
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        /*
         * TBD
         *
         * Use the 'nextInt' method of Scanner class to read user responses as
         * integers.
         *
         * There is enough work to do here that you may want to introduce
         * private methods (i.e. helper methods).
         */
    	while(gameInProgress == true) {
    		PlayerTurn();
    		CheckForWinner();
    		AITurn();
    		CheckForWinner();
    		
    		
    		
    		
    	}
    	
    	
   		
   		
    	
    	
    }
    
    public void PlayerTurn() {
    	System.out.print("Enter desired x-coordinate: ");
    	userXChoice = scanner.nextInt();  
    	
    	System.out.print("Enter desired y-coordinate: ");
    	userYChoice = scanner.nextInt();
    	
    	game.placePlayerPiece(userXChoice, userYChoice); //places the piece in chosen place
    	System.out.print("After your move: ");
    	System.out.print(this.board.toString());
    }
    
    
    
    public void CheckForWinner() {
    
    	//in x axis
    	for(int j = 0; j <3; j++) {
    		if ((board.get(0, j) == board.get(1, j)) && (board.get(1, j) == board.get(2, j)) && (board.get(2, j) == board.get(0, j))) {
    			 winningChar = board.get(0, j);
    			 if (winningChar == game.playerSelection) {
    				 System.out.print("You won!");
    			 } else {
    				 System.out.print("Loser!");
    			 }
    			 
    		}
        		
        }
    }
    
    
    public void AITurn() {
    	game.aiPlacePiece();
    	System.out.print("After AI move: ");
    	System.out.print(this.board.toString());
    }
    
    public boolean CheckForDraw() {
    	if(board.isFull() == true) {
			return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
}
