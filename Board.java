/**
 * The Board class is responsible for the condition of the board: the size of the board,
 * marking squares and keeping everything marked on the board. The numbering of the slots on the board starts with 0.
 */
public class Board {
    /**
     * A constant for the default board size
     */
    private static final int DEFAULT_BOARD_SIZE = 4;
    /**
     * The size of the board. if n = size then the board is of size n x n.
     */
    private int Size;
    /**
     * a 2D array board of Mark values.
     */
    private Mark[][] board;

    /**
     * A default constructor, defines a new empty array of dipole size.
     */
    public Board() {
        this.Size = DEFAULT_BOARD_SIZE;
        this.board = new Mark[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        for(int i = 0; i < DEFAULT_BOARD_SIZE; i++) {
            for(int j = 0; j < DEFAULT_BOARD_SIZE; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * Another constructor, defines a new empty array of size <size>.
     * @param size size of the board.
     */
    public Board(int size) {
        this.Size = size;
        this.board = new Mark[size][size];
        for(int i = 0; i < this.Size; i++) {
            for(int j = 0; j < this.Size; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * public getter that returns the size of the board.
     * @return size of the board.
     */
    public int getSize() {
        return this.Size;
    }

    /**
     * Returns the 2D array that represents the board.
     * @return 2D array of Mark values.
     */
    public Mark[][] getBoard() {
        return this.board;
    }

    /**
     * Private method that checks if a coordinate (row, col) is valid coordinate s.t: [0<=row, col <= boardSize]
     * @param row row of the coordinate.
     * @param col col of the coordinate.
     * @return Returns a boolean value, true if is a valid coordinate, false otherwise.
     */
    private boolean validCoordinate(int row, int col) {
        return row >= 0 && col >= 0 && row < this.Size && col < this.Size;
    }

    /**
     * Try to mark the box (row, col) in mark. Returning true if and only if it marked the box successfully
     * (according to standard game rules).
     * @param mark Mark value X, O or BLANK
     * @param row Row of the desired mark coordinate.
     * @param col Col of the desired mark coordinate.
     * @return Returns a boolean value, being true if it marked the box successfully false otherwise.
     */
    public boolean putMark(Mark mark, int row, int col) {
        if(validCoordinate(row, col) && this.board[row][col] == Mark.BLANK){
            this.board[row][col] = mark;
            return true;
        }
        return false;
    }

    /**
     * Return the mark that is in the given slot. In case of invalid coordinates will return BLANK value of Mark.
     * @param row Row of the desired mark coordinate.
     * @param col Col of the desired mark coordinate.
     * @return Returns a Mark value of the mark that is in the given slot
     */
    public Mark getMark(int row, int col) {
        if(validCoordinate(row, col)){
            return this.board[row][col];
        }
        return Mark.BLANK;
    }
}
