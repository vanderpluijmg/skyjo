package Model;

import Obs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents all useful functions to play a game.
 *
 * @author Gregory
 */
public class Game implements Observable, Model{

    private List<Observer> observers;
    private final Deck deck;
    private final Player[] players;

    /**
     * Default constructor for game.
     */
    public Game() {
        observers = new ArrayList<>();
        this.deck = new Deck();
        this.players = new Player[3];
        this.players[1] = new Player();
        this.players[2] = new Player();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shuffleDeck() {
        this.deck.shuffleDeck();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player[] getPlayers() {
        return this.players;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Card piocheCarte() {
        if (deck.isEmpty()) {
            throw new IllegalArgumentException("Deck is emtpy");
        }
        return this.deck.hitDeck(true);
    }

    /**
     * {@inheritDoc}
     */
    public void showCard(Card card) {
        card.setVisibility(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPlayerTot(int p) {
        return Integer.toString(players[p].getNbOFPointsVisCards());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void distribInit() {
        for (int i = 0; i < 12; i++) {
            try {
                Card cardP1 = this.deck.removeLast();
                Card cardP2 = this.deck.removeLast();
                this.players[1].addCard(cardP1);
                this.players[1].addPoints(cardP1);
                this.players[2].addCard(cardP2);
                this.players[2].addPoints(cardP2);
            } catch (Exception e) {
                throw new IllegalArgumentException("Deck is empty");
            }

        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printDeck() {
        deck.print();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFirstToPlay() {
        return players[1].getNbOFPointsVisCards()
                > players[2].getNbOFPointsVisCards() ? "1" : "2";
    }

    @Override
    public void notifyObserver(Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }
}
