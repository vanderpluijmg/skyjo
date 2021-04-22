package Controller;

import Model.Card;
import Model.Model;
import Model.Player;
import fxLayout.viewInterface;

/**
 * Controller for the game.
 * @author Gregory
 */
public class Controller {
    
    private final Model game;
    private final viewInterface view;
    
    /**
     * Constructor for controller.
     * @param view View to display game.
     * @param game Model to control game.
     */
    public Controller(viewInterface view, Model game) {
        this.view = view;
        this.game = game;
    }

    /**
     * Starts a new game
     */
    public void start() {
        while (!over()){
            playMove(switchTurn());
            game.addUtils();
            }
    }

    /**
     * Switches current player
     * @return Player who's turn it switched to.
     */
    public Player switchTurn(){
        return game.nextToPlay();
    }
    
    /**
     * Checks if the game is over.
     * @return True if the game is over.
     */
    public boolean over() {
        return game.getPlayingPlayer() == 2 && allCardVis();
    }
    
    /**
     * Checks if all cards of a player are visible. //Still needs work what if a player one no but 2 yes?
     * @return True if all cards are visible.
     */
    public boolean allCardVis(){  // Int that track sin player number of visible card to not always go threw list
        for (int i = 1; i <= 2; i++) 
            for (Card card : game.getPlayers()[i].getPlayerCard()) 
                if (!card.isVisibiltiy())
                    return false;
        return true;
    }

    /**
     * Plays a move of a player. //Play move and apply correct statuses of game.
     * @param player Player that will play move.
     */
    public void playMove(Player player) {
        game.shuffleDeck();
        game.distribInit();
        for (int i = 1; i<=2; i++)
            game.getPlayers()[i].showRandomCardStart();
    }
    
    /**
     * Adds current view obs.
     */
    public void addObs(){
        game.registerObs(view);
    }
}
