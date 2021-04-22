package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player. Each player has a hand of card and a number of points
 * from each visible card.
 *
 * @author Gregory
 */
public class Player {

    private ArrayList<Card> playerCards;
    private int nbOFPointsVisCards;

    /**
     * Default constructor of Player
     */
    public Player() {
        this.nbOFPointsVisCards = 0;
        playerCards = new ArrayList();
    }

    /**
     * Getter for number of points of player.
     *
     * @return Number of points of player.
     */
    public int getNbOFPointsVisCards() {
        return this.nbOFPointsVisCards;
    }

    /**
     * Adds card to total.
     *
     * @param card Card to add to total.
     */
    public void addPoints(Card card) {
        if (card.isVisibiltiy()) {
            this.nbOFPointsVisCards += card.getValue();
        }
    }

    /**
     * Getter for the list of cards from the player.
     *
     * @return List of player's cards.
     */
    public List<Card> getPlayerCard() {
        return this.playerCards;
    }

    /**
     * Gets player card at Index.
     *
     * @param index Index to get card from.
     * @return Card at index in player hand.
     */
    public Card getPlayerCardAtIndex(int index) {
        return this.playerCards.get(index);
    }

    /**
     * Adds a new Card to the current deck of card of player
     *
     * @param card Card to add to deck of player.
     */
    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        this.playerCards.add(card);
    }

    /**
     * Makes two card randomly visible at begin of game.
     */
    public void showRandomCardStart() {
        int first = (int) (Math.random() * ((11 - 0) + 1) + 0);
        int second = (int) (Math.random() * ((11 - 0) + 1) + 0);
        while (first == second) {
            second = (int) (Math.random() * ((11 - 0) + 1) + 0);
        }
        playerCards.get(first).hasVisibility(true);
        addPoints(playerCards.get(first));
        playerCards.get(second).hasVisibility(true);
        addPoints(playerCards.get(second));
    }

    /**
     * Prints the hand of current player in console.
     */
    public void printHand() {
        playerCards.forEach((t) -> {
            System.out.println(t);
        });
    }

}
