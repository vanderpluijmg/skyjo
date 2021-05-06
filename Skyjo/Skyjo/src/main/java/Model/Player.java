package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a player. Each player has a hand of card and a number of points
 * from each visible card.
 *
 * @author Gregory
 */
public class Player {

    private final ArrayList<Card> playerCards;
    private int nbOFPointsVisCards;
    private int nbOfVisCards;

    /**
     * Default constructor of Player
     */
    public Player() {
        this.nbOfVisCards = 0;
        this.nbOFPointsVisCards = 0;
        this.playerCards = new ArrayList();
    }
    
    /**
     * Returns the number of visible cards.
     *
     * @return Number of visible cards of player.
     */
    public int getNbOfVisCards() {
        return nbOfVisCards;
    }

    public void setNbOFPointsVisCards(int nbOFPointsVisCards) {
        this.nbOFPointsVisCards = nbOFPointsVisCards;
    }
    
    

    /**
     * Getter for number of points of player.
     *
     * @return Number of points of player.
     */
    public int getNbOFPointsVisCards() {
        return this.nbOFPointsVisCards;
    }
    
    public void updateTot(){
        this.nbOFPointsVisCards = 0;
        this.nbOfVisCards = 0;
        for (var x : playerCards){
            addPoints(x);
        }
    }

    /**
     * Adds card to total.
     *
     * @param card Card to add to total.
     */
    public void addPoints(Card card) {
        Objects.requireNonNull(card);
        if (card.isVisibiltiy()) {
            this.nbOFPointsVisCards += card.getValue();
            this.nbOfVisCards++;
        }
    }

    /**
     * Adds a new Card to the current deck of card of player
     *
     * @param card Card to add to deck of player.
     */
    public void addCard(Card card) {
        Objects.requireNonNull(card);
        this.playerCards.add(card);
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
        Objects.requireNonNull(index);
        return this.playerCards.get(index);
    }

    /**
     * Switches index of an old card with a new card.
     *
     * @param index Index to switch.
     * @param card New card that will take place of the old one.
     */
    public void switchIndex(int index, Card card) {
        Objects.requireNonNull(card);
        Objects.requireNonNull(index);
        playerCards.set(index, card);
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
