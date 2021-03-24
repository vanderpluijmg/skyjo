package Model;

import java.util.Collections;
import java.util.List;

/**
 * Represents a collection of Card to create a "deck of card".
 * @author Gregory
 */
public class Deck {
    
    private List <Card> deck;
    
    /**
     * Constructor of a deck of 150 card of game Skyjo.
     */
    public Deck (){
        int nbToAdd = -2;
        int timesToAdd = 5; 
        for (int j = 0; j<timesToAdd; j++){
            
        }
        for (int i =0; i<150; i++){
            if (i%10==0){
                
            }
        }
    }
    
    /**
     * Shuffles deck of given cards.
     */
    public void shuffleDeck (){
        Collections.shuffle(this.deck);
    }
    public Card removeLast(){
        return this.deck.remove(this.deck.size()-1);
    }
    
    /**
     * 
     * @return 
     */
    public Card hitDeck (boolean show){
        Card card = this.deck.remove(deck.size()-1);
        if (show == true)
            card.setVisibility(true);
        return card;
    }

    public boolean isEmpty() {
        return this.deck.isEmpty();
    }
}
