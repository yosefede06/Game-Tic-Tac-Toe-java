/**
 * Fills blanks blocks of the board vertically and in order from left to right and from columns to rows, starting
 * from (1, 1) and in case no more blocks are available on that interval starts filling the first column.
 * His main goal is to defeat the clever player 100% of the times, and to win more than 55% of the times the whatever
 * player.
 */
public class GeniusPlayer implements Player {

    /**
     * Returns a list representing the order that the genius players has to follow
     * in order to fill the blank spaces of the board.
     * @param board current board of the game.
     * @return A list of blank coordinates of the board.
     */
    private int[] getOrderByColumns(Board board) {
        int[] blankArr = new int[board.getSize() * board.getSize()];
        int ind = 0;
        for(int i = 1; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                if(board.getBoard()[j][i] == Mark.BLANK) {
                    blankArr[ind] = j * board.getSize() + i;
                    ind++;
                }
            }
        }
        for(int j = 0; j < board.getSize(); j++) {
            if(board.getBoard()[j][0] == Mark.BLANK) {
                blankArr[ind] = j * board.getSize();
                ind++;
            }
        }

        return blankArr;
    }

    /**
     * Asks for the blank coordinates of the board in the order specified above and picks the first value of the list.
     * @param board Board of the game.
     * @param mark Mark of the player who plays in current turn.
     */
    public void playTurn(Board board, Mark mark) {
        int[] blankCoordinates = this.getOrderByColumns(board);
        board.putMark(mark, blankCoordinates[0] / board.getSize(), blankCoordinates[0] % board.getSize());
    }
}
