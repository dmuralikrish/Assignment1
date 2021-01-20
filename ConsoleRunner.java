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
    private Scanner scanner = new Scanner(System.in); // Use to process text input from the user.
    String userResponseX;
    String userResponseChallenge;    
    int userXChoice;
    int userYChoice;    
    private boolean challenging;    
    Board board = new Board();
    Move move;    
    private GameStatus gameStat = GameStatus.IN_PROGRESS;; 
    
    /**
     * Constructor
     */
    public ConsoleRunner() {    
        System.out.print("Do you want to play as X (Y/N): \n");  
    	userResponseX = scanner.nextLine();  
    	
    	System.out.print("Do you want a challenge (Y/N): \n");  
    	userResponseChallenge = scanner.nextLine();  

    	this.playerIsX = userResponseX.matches("Y");
    	this.challenging = userResponseChallenge.matches("Y");
    	this.game = new Game(playerIsX, challenging);  	
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        System.out.print(board.toString());
    	do{
    		if (playerIsX == true) {
    			PlayerTurn();
    			AITurn();
    			this.game.getBoard();
    			game.getStatus();
    			
    		} else if (playerIsX == false) {
    			AITurn();
    			PlayerTurn();
    			game.getBoard();
    			game.getStatus();
    		}    		
    	}while(game.getStatus() == GameStatus.IN_PROGRESS);	    	
    }
    
    public void PlayerTurn() {
    	System.out.print("Enter desired x-coordinate: ");
    	userXChoice = scanner.nextInt();  
    	
    	System.out.print("Enter desired y-coordinate: ");
    	userYChoice = scanner.nextInt();
    	
    	//places the piece in chosen place
    	game.placePlayerPiece(userXChoice, userYChoice); 
    	System.out.print("After your move: ");
    	System.out.print(this.game.getBoard());
    }
    
    
    

    
    
    public void AITurn() {
    	game.aiPlacePiece();
    	System.out.print("After AI move: ");
    	System.out.print(this.game.getBoard());
    }
    

    
    
}
