package Model;

/**
 * Represents a card with a value and wether or not it is visible on game.
 *
 * @author Gregory
 */
public class Card {

    private final int value;
    private boolean visible;

    /**
     * Constructor for Card.
     *
     * @param value Value to give to card.
     */
    public Card(int value) {
        this.value = value;
        this.visible = false;
    }

    /**
     * Getter for value of card.
     *
     * @return Value of current card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for visibility of card.
     *
     * @param vis Visibility to set.
     */
    public void hasVisibility(boolean vis) {
        this.visible = vis;
    }

    /**
     * Gets the visibility of a card.
     *
     * @return Visibility of card.
     */
    public boolean isVisibiltiy() {
        return this.visible;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public String toString() {
        return Integer.toString(getValue())+ " " + isVisibiltiy();
    }

}
