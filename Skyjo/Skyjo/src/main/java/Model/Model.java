package Model;

/**
 * Interface of a game.
 *
 * @author Gregory
 */
public interface Model {

    /**
     * Take a card from the top of the deck.
     *
     * @return Card that has been picked.
     */
    public Card piocheCarte();

    /**
     * Gets a player total values of shown cards
     *
     * @param p Player to get total from.
     * @return Total of player in String format.
     */
    public String getPlayerTot(int p);

    /**
     * Distributes the first 12 card to each player.
     */
    public void distribInit();

    /**
     * Gets the Array of players participating in the game.
     *
     * @return An Array of players.
     */
    public Player[] getPlayers();

    /**
     * Prints the deck in the console.
     */
    public void printDeck();

    /**
     * Shuffles the deck.
     */
    public void shuffleDeck();

    /**
     * Gets the player that is allowed to start the game.
     *
     * @return Format in numerical of player allowed to start.
     */
    public String getFirstToPlay();
}
