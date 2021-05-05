package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import fxLayout.ViewInterface;
import javafx.scene.control.Button;

/**
 * Represents all useful functions to play a game.
 *
 * @author Gregory
 */
public class Game implements Model {

    private final List<ViewInterface> observers;
    private final Deck deck;
    private final Player[] players;
    private Player currentPlayer;
    private GameState status;
    private boolean trashPackClicked;
    private boolean drawPackClicked;
    private int firstPlayer;

    /**
     * Default constructor for game.
     */
    public Game() {
        observers = new ArrayList<>();
        this.deck = new Deck();
        this.players = new Player[3];
        this.players[1] = new Player();
        this.players[2] = new Player();
        status = GameState.PRENDREUNECARTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameState getStatus() {
        return status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStatus(GameState status) {
        Objects.requireNonNull(status);
        this.status = status;
        if (this.status == GameState.PRENDREUNECARTE) {
            nextToPlay();
        }
        for (var x : observers) {
            x.updateInstructions();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyEndOfTurn() {
        if (!isOver()){
            setDrawPackClicked(false);
            setTrashPackClicked(false);
            setStatus(GameState.PRENDREUNECARTE);
        } else {
            System.out.println(checkForWinner()); 
            //Double score if player that has finished first if has bigger or equal score to last finishing player
        }
    }
    
    /**
     * If game is over check for a winner.
     * @return Player that has won the game.
     */
    private int checkForWinner(){
        return players[1].getNbOFPointsVisCards() > players[2].getNbOFPointsVisCards() ? 2 : 1;
    }
    
    /**
     * Checks if the game is over.
     *
     * @return True if the game is over.
     */
    private boolean isOver() {
        return allCardVis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrentPlayer() {
        return players[2].equals(this.currentPlayer)
                ? 2 : 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void nextToPlay() {
        if (getCurrentPlayer() == 2) {
            this.currentPlayer = players[1];
        } else {
            this.currentPlayer = players[2];
        }
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
     * {@inheritDoc}
     */
    @Override
    public void setCurrentPlayer() {
        this.currentPlayer = getFirstToPlay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cardIsClicked(Button playerCard, int player, int index) {
        for (var x : observers) {
            x.updateCards(playerCard, player, index);
        }
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
    public void notifyDrawPack() {
        for (var x : observers) {
            x.updateDrawDeck();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyTrashPack() {
        for (var x : observers) {
            x.updateTrashPack();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyPlayerAndTot(int player) {
        players[player].updateTot();
        for (var x : observers) {
            x.updateScoreAndPlayer(player);
        }
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
     * Show given card.
     *
     * @param card Card to show.
     */
    private void showCard(Card card) {
        Objects.requireNonNull(card);
        card.hasVisibility(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPlayerTot(int p) {
        Objects.requireNonNull(p);
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
    public void registerObs(ViewInterface obs) {
        Objects.requireNonNull(obs);
        observers.add(obs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTrashPackClicked() {
        return trashPackClicked;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTrashPackClicked(boolean trashPackClicked) {
        Objects.requireNonNull(trashPackClicked);
        this.trashPackClicked = trashPackClicked;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDrawPackClicked() {
        return drawPackClicked;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDrawPackClicked(boolean drawPackClicked) {
        Objects.requireNonNull(drawPackClicked);
        this.drawPackClicked = drawPackClicked;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Card getCurrentCard() {
        return this.deck.getCurCard();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Card getTrashCard() {
        return this.deck.getTrashCard();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Deck getDeck() {
        return this.deck;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTrashCard(Card card) {
        Objects.requireNonNull(card);
        this.deck.setTrashCard(card);
    }

    /**
     * Checks if all cards for one player are all visible.
     *
     * @return True if at least one player has all his card visible.
     */
    private boolean allCardVis() {
        boolean vis=false;
        for (int i = 1; i <= 2; i++) {
            if (getPlayers()[i].getNbOfVisCards() == 12) {
                vis=true;
            }
            vis = false;
        }
        return vis;
    }

    
}
