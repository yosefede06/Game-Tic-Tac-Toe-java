/**
 * An instance of the class represents a single game.
 * He must know when the game ended, who was the winner and whether it ended in a draw.
 */
public class Game {
    /**
     * A constant for the default board size
     */
    private final static int DEFAULT_BOARD_SIZE = 4;
    /**
     * A constant for the default win streak
     */
    private final static int DEFAULT_WIN_STREAK = 3;
    /**
     * Player 1/2 according to the current round of the game.
     */
    private Player playerX;
    /**
     * Player 1/2 according to the current round of the game.
     */
    private Player playerO;
    /**
     * Instance of the class Renderer which can be an uppercase of ConsoleRenderer or VoidRenderer.
     */
    private Renderer renderer;
    /**
     * Board of the game.
     */
    private Board board;
    /**
     * A player is defined as the winner if he has obtained on the board a sequence of winStreak
     * squares marked with his mark.
     */
    private int winStreak;

    /**
     * Constructor, defines a new game, with default values.
     * @param playerX Player 1/2 depending on the current round of the game.
     * @param playerO Player 1/2 depending on the current round of the game.
     * @param renderer Instance of the class Renderer which can be an uppercase of ConsoleRenderer or VoidRenderer.
     */
    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.board = new Board(DEFAULT_BOARD_SIZE);
        this.winStreak = DEFAULT_WIN_STREAK;
    }

    /**
     * Another constructor, defines an array of size <size>, and a sequence of victories of size <winStreak>.
     * If an invalid value is entered, the winning streak will be set to equal the size of the board.
     * @param playerX Player 1/2 according to the current round of the game.
     * @param playerO Player 1/2 according to the current round of the game.
     * @param size int. Size of the board.
     * @param winStreak A player is defined as the winner if he has obtained on the board a sequence of winStreak
     * squares marked with his mark.
     * @param renderer Instance of the class Renderer which can be an uppercase of ConsoleRenderer or VoidRenderer.
     */
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.board = new Board(size);
        this.winStreak = winStreak;
    }

    /**
     * Getter of the winStreak for access from other classes.
     * @return int winStreak.
     */
    public int getWinStreak() {
        return this.winStreak;
    }

    /**
     * Checks if there is winner on the current board. The function iterate through every block of the board and
     * checks if there is a winner streak that starts (or ends) from/on that block.
     * @return a boolean value. In case one of the blocks satisfies the condition explained above the method returns
     * true else return false.
     */
    private boolean checkExistWinner() {
        for(int i = 0; i < this.board.getSize(); i++) {
            for(int j = 0; j < this.board.getSize(); j++) {
                if(validityDown(i, j) || validityLeft(i, j) || validityUp(i, j) ||
                        validityRight(i, j) || validityDownLeft(i, j) || validityDownRight(i, j)
                        || validityUpLeft(i, j) || validityUpRight(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there is an up vertical winning streak starting from the block (i, j)
     * @param i row place of the current coordinate
     * @param j col place of the current coordinate
     * @return True if there is a winning streak, false otherwise.
     */
    private boolean validityUp(int i, int j) {
        int count = 0;
        Mark curr = this.board.getBoard()[i][j];
        while(this.board.getMark(i, j) != Mark.BLANK && curr == this.board.getBoard()[i][j]){
            count++;
            if(count == winStreak){
                return true;
            }
            i--;
        }
        return false;
    }

    /**
     * Checks if there is a left horizontal winning streak starting from the block (i, j)
     * @param i row place of the current coordinate
     * @param j col place of the current coordinate
     * @return True if there is a winning streak, false otherwise.
     */
    private boolean validityLeft(int i, int j) {
        int count = 0;
        Mark curr = this.board.getBoard()[i][j];
        while(this.board.getMark(i, j) != Mark.BLANK && curr == this.board.getBoard()[i][j]){
            count++;
            if(count == winStreak){
                return true;
            }
            j--;
        }
        return false;
    }

    /**
     * Checks if there is a down vertical winning streak starting from the block (i, j)
     * @param i row place of the current coordinate
     * @param j col place of the current coordinate
     * @return True if there is a winning streak, false otherwise.
     */
    private boolean validityDown(int i, int j) {
        int count = 0;
        Mark curr = this.board.getBoard()[i][j];
        while(this.board.getMark(i, j) != Mark.BLANK && curr == this.board.getBoard()[i][j]){
            count++;
            if(count == winStreak){
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * Checks if there is an right horizontal winning streak starting from the block (i, j)
     * @param i row place of the current coordinate
     * @param j col place of the current coordinate
     * @return True if there is a winning streak, false otherwise.
     */
    private boolean validityRight(int i, int j) {
        int count = 0;
        Mark curr = this.board.getBoard()[i][j];
        while(this.board.getMark(i, j) != Mark.BLANK && curr == this.board.getBoard()[i][j]){
            count++;
            if(count == winStreak){
                return true;
            }
            i--;
        }
        return false;
    }

    /**
     * Checks if there is a down right diagonal winning streak starting from the block (i, j)
     * @param i row place of the current coordinate
     * @param j col place of the current coordinate
     * @return True if there is a winning streak, false otherwise.
     */
    private boolean validityDownRight(int i, int j) {
        int count = 0;
        Mark curr = this.board.getBoard()[i][j];
        while(this.board.getMark(i, j) != Mark.BLANK && curr == this.board.getBoard()[i][j]){
            count++;
            if(count == winStreak){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    /**
     * Checks if there is an up right diagonal winning streak starting from the block (i, j)
     * @param i row place of the current coordinate
     * @param j col place of the current coordinate
     * @return True if there is a winning streak, false otherwise.
     */
    private boolean validityUpRight(int i, int j) {
        int count = 0;
        Mark curr = this.board.getBoard()[i][j];
        while(this.board.getMark(i, j) != Mark.BLANK && curr == this.board.getBoard()[i][j]){
            count++;
            if(count == winStreak){
                return true;
            }
            i--;
            j++;
        }
        return false;
    }

    /**
     * Checks if there is an up left diagonal winning streak starting from the block (i, j)
     * @param i row place of the current coordinate
     * @param j col place of the current coordinate
     * @return True if there is a winning streak, false otherwise.
     */
    private boolean validityUpLeft(int i, int j) {
        int count = 0;
        Mark curr = this.board.getBoard()[i][j];
        while(this.board.getMark(i, j) != Mark.BLANK && curr == this.board.getBoard()[i][j]){
            count++;
            if(count == winStreak){
                return true;
            }
            i--;
            j--;
        }
        return false;
    }

    /**
     * Checks if there is a down left diagonal winning streak starting from the block (i, j)
     * @param i row place of the current coordinate
     * @param j col place of the current coordinate
     * @return True if there is a winning streak, false otherwise.
     */
    private boolean validityDownLeft(int i, int j) {
        int count = 0;
        Mark curr = this.board.getBoard()[i][j];
        while(this.board.getMark(i, j) != Mark.BLANK && curr == this.board.getBoard()[i][j]){
            count++;
            if(count == winStreak){
                return true;
            }
            i++;
            j--;
        }
        return false;
    }

    /**
     * Returns the number of white blocks of the current board of the game.
     * @param board board of the game.
     * @return Int value representing the number of free blocks.
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
     * Runs the course of a game - from start to finish its over, and returns the winner.
     * The game ends when one of the players. There is a winning streak or when there are no slots left
     * blanks in the board. In case the game is over. In case the game finishes in draw, BLANK will be returned
     * @return Returns a MARK field representing the result of the current game played.
     */
    public Mark run() {
        int turn = 0;
        Mark[] playersTurn = {Mark.X, Mark.O};
        Player[] players = {this.playerX, this.playerO};
        while(this.getBlankNumber(this.board) > 0 && !this.checkExistWinner()) {
            players[turn % 2].playTurn(this.board, playersTurn[turn % 2]);
            turn++;
            this.renderer.renderBoard(this.board);
        }
        if(this.getBlankNumber(this.board) != 0){
            return playersTurn[++turn % 2];
        }
        return Mark.BLANK;
    }
}
