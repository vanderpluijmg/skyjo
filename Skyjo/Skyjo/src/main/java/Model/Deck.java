package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Represents a collection of Card to create a "deck of card".
 *
 * @author Gregory
 */
public class Deck {

    private final ArrayList<Card> deck;
    private Card curCard;
    private Card trashCard;

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
        Objects.requireNonNull(show);
        Card card = this.deck.remove(deck.size() - 1);
        if (show == true) {
            card.hasVisibility(true);
        }
        this.curCard = card;
        return card;
    }

    /**
     * Checks if deck is empty.
     *
     * @return True if deck is empty.
     */
    public boolean isEmpty() {
        return this.deck.isEmpty();
    }

    /**
     * Gets the current card of the deck.
     *
     * @return Card at the top of the deck.
     */
    public Card getCurCard() {
        return this.curCard;
    }

    /**
     * Gets the current card that sits in the trash.
     *
     * @return Card at the top of the deck.
     */
    public Card getTrashCard() {
        return this.trashCard;
    }

    /**
     * Sets the trash card to a new card.
     *
     * @param card Card to set as new trash card.
     */
    public void setTrashCard(Card card) {
        Objects.requireNonNull(card);
        this.trashCard = card;
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
