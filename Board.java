/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

public class Board {

    private char[][] board = new char[3][3];
  
    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct an empty board (contains all space char's).
     */
    public Board() {
    	 for(int i =0; i<3; i++){
            for(int j = 0; j<3; j++){
                board[i][j] = ' ';
            }
        }      	 
    }

    /**
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {
    	 for(int i = 0; i < 3; i++) {
         	for(int j = 0; j < 3; j++) {
         		this.board[i][j] = other.board[i][j];
         	}
    	 }
    	this.board[move.getI()][move.getJ()] = move.getPiece();
    }

    /**
     * Convert to a string that shows the board's state.
     */
    @Override
    public String toString() {
    	String boardString="";
        boardString += "\n-------\n|";
        for (int i=0; i<3; i++){
            for (int j=0;j<3;j++){
                boardString += board[i][j];
                if (j == 2){
                    boardString += '|';
                    boardString +='\n';
                }
                else {
                    boardString += '|';
                }
            }
            if (i<2) {
                boardString += "-------\n|";
            }
        }
        boardString += "-------\n";
        return boardString;
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
        if ((i >= 0 && i < 3) && (i >= 0 && i < 3)) {
        	return board[i][j];
        } else {
        	return 'W';                 //why W?
        }
    }
    
    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
        for(int i = 0; i < 3; i++) 
        	for(int j = 0; j < 3; j++) 
        		if(this.board[i][j] == ' ') 
        			return false;
        return true;
    }
}
