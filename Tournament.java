import java.util.*;
import java.lang.*;

/**
 * The Tournament class performs a series of X-circle games (rounds) between certain players in a certain rendering
 * interface, when: In the first round, the first player plays an X and the second a circle, and at the end of each
 * round they switch signs. In this way, in rounds with an even index the first player is X, while in the odd indices
 * it is the other way around.
 */
class Tournament {
    /**
     * Number of rounds the players need to play.
     */
    private int rounds;
    /**
     * Instance of the class Renderer which can be an uppercase of ConsoleRenderer or VoidRenderer.
     */
    private Renderer renderer;
    /**
     * Array of Player instances.
     */
    private Player[] players;
    /**
     * Contains the current total number for player 1 and player 2.
     */
    private int[] wins;
    /**
     * Array of String with valid players strings received from the input.
     */
    static final String[] validPlayers = {"human", "clever", "whatever", "genius"};

    /**
     * The main method. A user who wants to run the game, will type the following command:
     * Java Tournament [round count] [size] [win_streak] [render target: console/none]
     * [player: human/whatever/clever/genius]⨉2
     * If there is a typo error in one of the players' names, an informative message will be printed on the screen
     * and the running of the program will end without running a tournament.
     * @param args [round count] [size] [win_streak] [render target: console/none]
     *             [player: human/whatever/clever/genius]⨉2
     */
    public static void main(String[] args) {
        String roundCount = args[0];
        String size = args[1];
        String winStreak = args[2];
        String renderTarget = args[3];
        String player1 = args[4].toLowerCase();
        String player2 = args[5].toLowerCase();
        if(!validityPlayer(player1) || !validityPlayer(player2)){
            System.out.println("Choose a player, and start again\nThe players: [human, clever, whatever, genius]");
            System.exit(0);
        }
        else{
            Player[] players  = {new PlayerFactory().buildPlayer(player1), new PlayerFactory().buildPlayer(player2)};
            Tournament tournament = new Tournament(Integer.parseInt(roundCount), new RendererFactory().buildRenderer(renderTarget, Integer.parseInt(size)), players);
            String[] playersName = {player1, player2};
            tournament.PlayTournament(Integer.parseInt(size), Integer.parseInt(winStreak), playersName);
        }
    }

    /**
     * Private method to check from the main function if the player string is valid or not.
     * A valid player s
     * @param player arg[4] or arg[5].
     * @return Boolean value true if the player string is valid else false.
     */
    private static boolean validityPlayer(String player) {
        for(String validPlayer: Tournament.validPlayers){
            if(player.equals(validPlayer)){
                return true;
            }
        }
        return false;
    }

    /**
     * Constructor.
     * @param rounds Number of rounds for each game.
     * @param renderer Renderer instance.
     * @param players Array of the 2 players of the game.
     */
    public Tournament(int rounds, Renderer renderer, Player[] players) {
        this.wins = new int[2];
        this.players = new Player[2];
        this.players[0] = players[0];
        this.players[1] = players[1];
        this.rounds = rounds;
        this.renderer = renderer;
    }

    /**
     * Called by main function, and here is where all the logic takes place iterating each round and calling Play.
     * The names of the players are found in row arguments args[4], args[5].
     * @param size Size of the board.
     * @param winStreak win streak of the tournament.
     * @param playerNames Array of player names.
     */
    public void PlayTournament(int size, int winStreak, String[] playerNames) {
        int ties = 0;
        for(int round = 0; round < this.rounds; round++) {
            Game game = new Game(this.players[round % 2], this.players[(round + 1) % 2], size, winStreak, this.renderer);
            Mark winner = game.run();
            if(winner == Mark.X) {
                this.wins[round % 2] += 1;
            }
            else if (winner == Mark.O) {
                this.wins[(round + 1) % 2] += 1;
            }
            else {
                ties++;
            }
            System.out.println("#########Results#########");
            System.out.format("Player 1, %s won: %d rounds\n", playerNames[0], this.wins[0]);
            System.out.format("Player 2, %s won: %d rounds\n", playerNames[1], this.wins[1]);
            System.out.format("Ties: %d\n", ties);
        }
    }
}