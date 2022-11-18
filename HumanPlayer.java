import java.util.Scanner;

/**
 * A human player decides with inputs the next movement on each of the turns of the game.
 */
public class HumanPlayer implements Player {
    Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor of the class.
     */
    public HumanPlayer() {

    }

    /**
     * Asks for a coordinate to the user and placed the move according to the coordinate received from the input.
     * Notice that in case the input was invalid it will call recursively the method still a valid input is encountered.
     * @param board Board of the game.
     * @param mark Mark of the player who plays in current turn.
     */
    public void playTurn(Board board, Mark mark) {
        if(!placeMove(board, mark, this.askForMovement(mark))) {
            System.out.println("Invalid coordinates, please try again:");
            this.playTurn(board, mark);
        }
    }

    /**
     * Private method which takes care of asking the coordinate/next movement to the humanPlayer.
     * @param mark Mark block state.
     * @return int input coordinate of the form: [row * size + col]
     */
    private int askForMovement(Mark mark) {
        System.out.println("Player " + mark + " type coordinates: ");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * private method in charge of making the movement given a board a mark and a coordinate.
     * @param board board of the current game.
     * @param mark Mark block state.
     * @param coordinate Coordinate of the form: [row * size + col]
     * @return True if the mark was successfully place, false otherwise.
     */
    private boolean placeMove(Board board, Mark mark, int coordinate) {
        return board.putMark(mark, coordinate / board.getSize(), coordinate % board.getSize());
    }
}
