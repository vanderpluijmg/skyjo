package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a collection of Card to create a "deck of card".
 *
 * @author Gregory
 */
public class Deck {

    private final ArrayList<Card> deck;

    /**
     * Constructor of a deck of 150 card of game Skyjo.
     */
    public Deck() {
        deck = new ArrayList();
        int timesToAdd = 5;
        int nbToAdd = -2;
        for (int j = 0; j < timesToAdd; j++) {
            deck.add(new Card(nbToAdd));
        }
        timesToAdd = 15;
        nbToAdd = 0;
        for (int j = 0; j < timesToAdd; j++) {
            deck.add(new Card(nbToAdd));
        }
        timesToAdd = 10;
        nbToAdd = -1;
        for (int j = 0; j < timesToAdd; j++) {
            deck.add(new Card(nbToAdd));
        }
        nbToAdd = 0;
        for (int i = 0; i < 120; i++) {
            if (i % 10 == 0) {
                nbToAdd++;
            }
            deck.add(new Card(nbToAdd));
        }
    }

    /**
     * Shuffles deck of given cards.
     */
    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    /**
     * Removes last card from deck.
     *
     * @return Last card of the deck
     */
    public Card removeLast() {
        return this.deck.remove(this.deck.size() - 1);
    }

    /**
     * Hits de deck to get a new Card.
     *
     * @param show Wether or not the new card needs to be shown or not.
     * @return
     */
    public Card hitDeck(boolean show) {
        Card card = this.deck.remove(deck.size() - 1);
        if (show == true) {
            card.hasVisibility(true);
        }
        return card;
    }

    /**
     * Checks if deck is emtpy.
     *
     * @return True if deck is emtpy.
     */
    public boolean isEmpty() {
        return this.deck.isEmpty();
    }

    /**
     * Prints the deck in the console.
     */
    public void print() {
        this.deck.forEach((t) -> {
            System.out.println(t);
        });
        System.out.println(this.deck.size());
    }
}
