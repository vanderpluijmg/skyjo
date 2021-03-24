package Model;

import java.util.List;

/**
 *
 * @author Gregory
 */
public class Player {
    private List <Card> PlayerCards;
    private int nbOFPointsVisCards;
    
    /**
     * Default constructor of Player
     */
    public Player (){
        this.nbOFPointsVisCards = 0;
    }
    
    /**
     * Getter for number of points of player.
     * @return Number of points of player.
     */
    public int getNbOFPointsVisCards(){
        return this.nbOFPointsVisCards;
    }
    
    /**
     * Adds card to total.
     * @param card Card to add to total.
     */
    public void addPoints (Card card){
        this.nbOFPointsVisCards+=card.getValue();
    }
    
    /**
     * Getter for the list of cards from the player.
     * @return List of player's cards.
     */
    public List<Card> getPlayerCard (){
        return this.PlayerCards;
    }
    
    /**
     * Adds a new Card to the current deck of card of player
     * @param card Card to add to deck of player.
     */
    public void addCard(Card card){
        if (card == null)
            throw new IllegalArgumentException("Card cannot be null");
        this.PlayerCards.add(card);
    }
    
    
   
    
    
}
