package Model;

/**
 *
 * @author Gregory
 */
public class Card {
    private final int value;
    private boolean visible;
    
    /**
     * Constructor for Card.
     * @param value Value to give to card.
     */
    public Card (int value){
        this.value = value;
        this.visible = false;
    }

    /**
     * Getter for value of card.
     * @return Value of current card.
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Setter for visibility of card.
     * @param vis Visibility to set.
     */
    public void setVisibility(boolean vis){
        this.visible = vis;
    }
    
}
