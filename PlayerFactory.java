/**
 * The PlayerFactory is responsible for mapping the string from the command line to an actual player object.
 */
public class PlayerFactory {
    public Player buildPlayer(String playerName) {
        Player player = null;
        switch(playerName.toLowerCase()) {
            case "human":
                player =  new HumanPlayer();
                break;
            case "clever":
                player =  new CleverPlayer();
                break;
            case "whatever":
                player =  new WhateverPlayer();
                break;
            case "genius":
                player = new GeniusPlayer();
                break;
        }
        return player;
    }
}
