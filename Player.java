/**
 * An interface that represents a particular logic or strategy for taking a turn in a game given a particular board
 */
public interface Player {
    /**
     * Executes the player's strategy.
     * @param board Board of the game.
     * @param mark Mark Represent the marking on the board.
     */
    public void playTurn(Board board, Mark mark);
}
