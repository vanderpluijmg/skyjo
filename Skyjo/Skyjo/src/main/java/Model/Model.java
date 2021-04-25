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
    
    /**
     * Gets the player that is currently playing.
     * @return The current playing player.
     */
    public int getPlayingPlayer();
    
    /**
     * Sets the current game status.
     * @param status Game status to set.
     */
    public void setStatus(gameState status);
    
    /**
     * Gets the current game status.
     * @return Current game status.
     */
    public gameState getStatus();
    
    /**
     * Sets if the trash pack has been clicked or not.
     * @param trashPackClicked True if trash pack has been clicked.
     */
    public void setTrashPackClicked(boolean trashPackClicked);
    
    /**
     * Checks if the trash pack has been clicked.
     * @return True if it has been clicked.
     */        
    public boolean isTrashPackClicked();
      
    /**
     * Sets if the draw pack has been clicked or not.
     * @param drawPackClicked True if draw pack has been clicked.
     */
    public void setDrawPackClicked(boolean drawPackClicked);
    
    /**
     * Checks if the draw pack has been clicked.
     * @return True if draw pack has been clicked.
     */
    public boolean isDrawPackClicked();
    
    /**
     * Gets the deck of the current game.
     * @return Deck of current game.
     */
    public Deck getDeck();
    
    /**
     * Gets the current card of the deck.
     * @return Card at the top of the deck.
     */
    public Card getCurrentCard();
}
