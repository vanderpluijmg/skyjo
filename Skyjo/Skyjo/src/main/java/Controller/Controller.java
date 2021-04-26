package Controller;

import Model.Card;
import Model.Model;
import Model.Player;
import Model.gameState;
import fxLayout.viewInterface;
import java.util.Objects;

/**
 * Controller for the game.
 *
 * @author Gregory
 */
public class Controller {

    private final Model game;
    private final viewInterface view;

    /**
     * Constructor for controller.
     *
     * @param view View to display game.
     * @param game Model to control game.
     */
    public Controller(viewInterface view, Model game) {
        this.view = view;
        this.game = game;
    }

    /**
     * Starts the whole process of a new game.
     */
    public void start() {
        startGame();
        while (!isOver()) {
            game.addUtils();

//        for (int i= 0; i<2; i++){
//            if (madeMove()) 
//        switchTurn();
//            playMove(switchTurn());
//            
//        }
        }
    }

    /**
     * Switches current player
     *
     * @return Player who's turn it switched to.
     */
    public Player switchTurn() {
        return game.nextToPlay();
    }

    /**
     * Checks if the game is over.
     *
     * @return True if the game is over.
     */
    public boolean isOver() {
        return game.getCurrentPlayer() == 2 && allCardVis();
    }

    /**
     * Checks if all cards of a player are visible.
     *
     * @return True if all cards are visible.
     */
    public boolean allCardVis() {
        for (int i = 1; i <= 2; i++) {
            if (game.getPlayers()[i].getNbOfVisCards() == 12) //Need to update visibilty of cards
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Puts the game in starting state.
     */
    public void startGame() {
        if (!game.getStatus().equals(gameState.PRENDREUNECARTE)) {
            throw new IllegalArgumentException("The game is not in starting mode");
        }
        game.setCurrentPlayer();
        game.shuffleDeck();
        game.distribInit();
        for (int i = 1; i <= 2; i++) {
            game.getPlayers()[i].showRandomCardStart();
        }
    }

    /**
     * Plays a move of a player.
     */
    public boolean madeMove() {
        return game.isDrawPackClicked() || game.isTrashPackClicked();
    }

    /**
     * Clicks the thrash pack.
     */
    public void clickTrashPack() {
        game.setTrashPackClicked(true);
    }

    /**
     * Gets the value of the trash pack.
     *
     * @return True if the trash pack is clicked.
     */
    public boolean getTrashPack() {
        return game.isTrashPackClicked();
    }

    /**
     * Clicks the draw pack.
     */
    public void clickDrawPack() {
        game.setDrawPackClicked(true);
    }

    /**
     * Gets the value of the draw pack.
     *
     * @return True if the draw pack is clicked.
     */
    public boolean getDrawPack() {
        return game.isDrawPackClicked();
    }

    /**
     * Adds current view obs.
     */
    public void addObs() {
        game.registerObs(view);
    }

    /**
     * Hits the deck.
     *
     * @return Returns top card.
     */
    public Card hitDeck() {
        return game.getDeck().hitDeck(true);
    }

    /**
     * Gets the current card of the deck.
     *
     * @return The card on top of the deck.
     */
    public Card getCurCard() {
        return game.getCurrentCard();
    }

    /**
     * Gets the current card that is sitting in the trash.
     *
     * @return The card sitting in the trash pile.
     */
    public Card getTrashCard() {
        return game.getTrashCard();
    }

    /**
     * Sets the current card of trash to a new card.
     *
     * @param card New current trash pack card.
     */
    public void setTrashCard(Card card) {
        Objects.requireNonNull(card);
        game.setTrashCard(card);
    }

    /**
     * Returns a players card at a specific index.
     *
     * @param index Index to get card at.
     * @param player Players hand to get card.
     * @return Card at a specific index in a players hand.
     */
    public Card getCardAtIndex(int index, int player) {
        return game.getPlayers()[player].getPlayerCardAtIndex(index);
    }

    /**
     * Unclick all buttons.
     */
    public void unclickAll() {
        game.setDrawPackClicked(false);
        game.setTrashPackClicked(false);
    }

    /**
     * Adds the given card to the player
     *
     * @param player Player to add card to.
     * @param card Card to get value of.
     */
    public void addPlayerPoints(int player, Card card) {
        Objects.requireNonNull(card);
        Objects.requireNonNull(player);
        game.getPlayers()[player].addPoints(card);
    }

    /**
     * Make the given card visible.
     *
     * @param index Index to get card at.
     * @param player Player hand to get card.
     */
    public void makeCardAtIndexVisible(int index, int player) {
        game.getPlayers()[player].getPlayerCardAtIndex(index).hasVisibility(true);
        addPlayerPoints(player, game.getPlayers()[player].getPlayerCardAtIndex(index));
        System.out.println(game.getPlayers()[1].getNbOFPointsVisCards());
    }

    /**
     * Switches the new card with the old card to keep indexes of card up to
     * date.
     *
     * @param newCard Card that will take place of the old.
     * @param index Index that needs updating.
     * @param player Player that the card belongs to.
     */
    public void switchCardIndex(Card newCard, int index, int player) {
        game.getPlayers()[player].switchIndex(index, newCard);
    }

    /**
     * Changes the state of the game.
     *
     * @param status
     */
    public void changeGameState(gameState status) {
        game.setStatus(status);
    }

    /**
     * Getter for the state of the game
     *
     * @return Stage of the current game.
     */
    public gameState getGameState() {
        return this.game.getStatus();
    }

    /**
     * Gets the int of the current playing player.
     *
     * @return 1 if player 1 is playing.
     */
    public int getPlayerTurn() {
        return game.getCurrentPlayer();
    }

}
