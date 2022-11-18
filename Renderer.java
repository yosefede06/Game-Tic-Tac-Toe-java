/**
 * An interface that represents a shape to display a move of X circle games on the screen.
 */
public interface Renderer {
    /**
     * Receives a board and displays it according to the form which is implemented.
     * @param board board of the game.
     */
    public void renderBoard(Board board);
}
