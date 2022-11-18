import java.util.Random;

/**
 * Chose randomly a coordinate from all the blank blocks of the board.
 */
public class WhateverPlayer implements Player {

    /**
     * Field defined shuffle a coordinate for the next movement of the player.
     */
    private static final Random random = new Random();

    /**
     * Shuffles a coordinate from a list of blank block coordinates or legal next moves of the current board and place
     * the move being the block that corresponds to the coordinate returned by the random function.
     * @param board Board of the game.
     * @param mark Mark of the player who plays in current turn.
     */
    public void playTurn(Board board, Mark mark) {
        int[] blankCoordinates = this.getBlankCoordinates(board);
        int longCoordinate = blankCoordinates[this.random.nextInt(this.getBlankNumber(board))];
        board.putMark(mark, longCoordinate / board.getSize(), longCoordinate % board.getSize());
    }

    /**
     * Private method that returns the number of blank blocks on the current board.
     * @param board Board of the game.
     * @return Returns an int number of blank blocks.
     */
    private int getBlankNumber(Board board) {
        int ind = 0;
        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                if(board.getBoard()[i][j] == Mark.BLANK) {
                    ind++;
                }
            }
        }
        return ind;
    }

    /**
     * Creates a list with all the blank coordinates of the board in order from row to columns horizontally.
     * @param board Board of the game.
     * @return Array of the blank coordinates.
     */
    private int[] getBlankCoordinates(Board board) {
        int[] blankArr = new int[board.getSize() * board.getSize()];
        int ind = 0;
        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                if(board.getBoard()[i][j] == Mark.BLANK) {
                    blankArr[ind] = i * board.getSize() + j;
                    ind++;
                }
            }
        }
        return blankArr;
    }
}
