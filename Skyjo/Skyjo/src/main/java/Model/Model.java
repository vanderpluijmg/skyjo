package Model;

import fxLayout.ViewInterface;
import javafx.scene.control.Button;

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

    public void updateDrawPack();
    
    public void updateTrashPack();
    
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
     *
     * @param obs Observer to add.
     */
    public void registerObs(ViewInterface obs);

    /**
     * Player that is suppose to play after current player.
     *
     * @return Next player to play.
     */
    public Player nextToPlay();

    /**
     * Gets the player that is currently playing.
     *
     * @return The current playing player.
     */
    public int getCurrentPlayer();

    /**
     * Sets the current game status.
     *
     * @param status Game status to set.
     */
    public void setStatus(GameState status);
    
    public void cardIsClicked(Button card, int index, int player);
    
    public void updatePlayerAndTot(int player);

    /**
     * Gets the current game status.
     *
     * @return Current game status.
     */
    public GameState getStatus();

    /**
     * Sets if the trash pack has been clicked or not.
     *
     * @param trashPackClicked True if trash pack has been clicked.
     */
    public void setTrashPackClicked(boolean trashPackClicked);

    /**
     * Checks if the trash pack has been clicked.
     *
     * @return True if it has been clicked.
     */
    public boolean isTrashPackClicked();

    /**
     * Sets if the draw pack has been clicked or not.
     *
     * @param drawPackClicked True if draw pack has been clicked.
     */
    public void setDrawPackClicked(boolean drawPackClicked);

    /**
     * Checks if the draw pack has been clicked.
     *
     * @return True if draw pack has been clicked.
     */
    public boolean isDrawPackClicked();

    /**
     * Gets the deck of the current game.
     *
     * @return Deck of current game.
     */
    public Deck getDeck();

    /**
     * Gets the current card of the deck.
     *
     * @return Card at the top of the deck.
     */
    public Card getCurrentCard();

    /**
     * Gets the current card that sits in the trash.
     *
     * @return Card that is currently in trash.
     */
    public Card getTrashCard();

    /**
     * Replaces current card that sits in the trash.
     *
     * @param card Card to set as new trash card.
     */
    public void setTrashCard(Card card);

    /**
     * Gets the player that should play first. Meaning he has the most points of
     * visible cards.
     */
    public void setCurrentPlayer();
}
