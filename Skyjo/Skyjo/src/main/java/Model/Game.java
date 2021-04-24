package Model;

import fxLayout.viewInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents all useful functions to play a game.
 *
 * @author Gregory
 */
public class Game implements Model{

    private final List<viewInterface> observers;
    private final Deck deck;
    private final Player[] players;
    private Player currentPlayer;
    private gameState status;
    private boolean trashPackClicked;
    private boolean drawPackClicked;

    
    
    /**
     * Default constructor for game.
     */
    public Game() {
        observers = new ArrayList<>();
        this.deck = new Deck();
        this.players = new Player[3];
        this.players[1] = new Player();
        this.players[2] = new Player();
        Player currentPlayer = getFirstToPlay();
        status = gameState.DEBUT;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public gameState getStatus() {
        return status;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void setStatus(gameState status) {
        this.status = status;
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
        card.hasVisibility(true);
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
     * Gets the player that is allowed to start the game.
     *
     * @return Player that need to play first.
     */
    private Player getFirstToPlay() {
        return players[1].getNbOFPointsVisCards()
                > players[2].getNbOFPointsVisCards() ? players[1] : players[2];
    }
    
    /**
     *{@inheritDoc}
     */
    @Override
    public Player nextToPlay() {
        if (players[2].equals(this.currentPlayer)) {
            this.currentPlayer = players[1];
            return players[1];
        }
        this.currentPlayer = players[2];
        return players[2];
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void registerObs(viewInterface obs) {
        Objects.requireNonNull(obs);
        observers.add(obs);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void notifyObs(Object arg) {
        Objects.requireNonNull(arg);
        observers.forEach(x -> {x.update(arg);});
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void addUtils() { 
        notifyObs(new Utils(this.deck, this.players)); 
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public int getPlayingPlayer() {
       return players[2].equals(this.currentPlayer)
                ? 2 : 1;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean isTrashPackClicked() {
        return trashPackClicked;
    }
    
    /**
     *{@inheritDoc}
     */
    @Override
    public void setTrashPackClicked(boolean trashPackClicked) {
        this.trashPackClicked = trashPackClicked;
    }
    
    /**
     *{@inheritDoc}
     */
    @Override
    public boolean isDrawPackClicked() {
        return drawPackClicked;
    }
    
    /**
     *{@inheritDoc}
     */
    @Override
    public void setDrawPackClicked(boolean drawPackClicked) {
        this.drawPackClicked = drawPackClicked;
    }
    
    /**
     *{@inheritDoc}
     */
    @Override
    public Deck getDeck(){
        return this.deck;
    }
    
}
