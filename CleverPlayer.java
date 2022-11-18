/**
 * Clever player strategy is to fill the blank blocks of the board horizontally
 * in order from left to right and from rows to columns starting from coordinate (0,0).
 */
public class CleverPlayer implements Player{
    /**
     * Asks for the blank coordinates of the board in the order specified above and picks the first value of the list.
     * @param board Board of the game.
     * @param mark Mark of the player who plays in current turn.
     */
    public void playTurn(Board board, Mark mark) {
        int[] blankCoordinates = this.getBlankCoordinates(board);
        board.putMark(mark, blankCoordinates[0] / board.getSize(), blankCoordinates[0] % board.getSize());
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
