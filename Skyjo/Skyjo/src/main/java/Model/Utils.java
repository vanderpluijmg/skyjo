package Model;

/**
 * Utilities given to update the observers.
 *
 * @author Gregory
 */
public class Utils {

    private final Deck deck;
    private final Player[] players;

    public Utils(Deck deck, Player[] players) {
        this.deck = deck;
        this.players = players;
    }

    /**
     * Gets the array of players in the game.
     *
     * @return An array of players.
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Gets the deck of card that currently in the game.
     *
     * @return Deck of cards.
     */
    public Deck getDeck() {
        return this.deck;
    }

}
