package Model;

import fxLayout.viewInterface;

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
     * @return Player that need to play first.
     */
    public Player getFirstToPlay();
    
    /**
     * Registers a new observer.
     * @param obs Observer to add.
     */
    public void registerObs(viewInterface obs);
    
    /**
     * Notifies all observers of new update.
     * @param arg Update to notify.
     */
    public void notifyObs(Object arg);
    
    /**
     * Adds the necessary utils to obs update.
     */
    public void addUtils();
    
    /**
     * Player that is suppose to play after current player.
     * @return Next player to play.
     */
    public Player nextToPlay();
}
