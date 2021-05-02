package Controller;

import Model.Game;
import Model.Player;
import Model.GameState;
import Model.Model;
import fxLayout.MainFx;
import fxLayout.ViewInterface;
import javafx.stage.Stage;

/**
 * Controller for the game.
 *
 * @author Gregory
 */
public class Controller {

    private final ViewInterface view;
    private final Model game;

    /**
     * Constructor for controller.
     *
     * @param game Game to launch.
     */
    public Controller() {
        game = new Game();
        this.view = new MainFx(game);
        
    }

    /**
     * Starts the whole process of a new game.
     */
    public void start(Stage stage) {
        startGame();
        view.start(stage);
        //while (!isOver()) {
            

//        for (int i= 0; i<2; i++){
//            if (madeMove()) 
//        switchTurn();
//            playMove(switchTurn());
//            
//        }
        
    }

    /**
     * Switches current player
     *
     * @return Player who's turn it switched to.
     */
    public Player switchTurn() {
        return game.nextToPlay();
    }

    /**
     * Checks if the game is over.
     *
     * @return True if the game is over.
     */
    public boolean isOver() {
        return game.getCurrentPlayer() == 2 && allCardVis();
    }

    /**
     * Checks if all cards of a player are visible.
     *
     * @return True if all cards are visible.
     */
    public boolean allCardVis() {
        for (int i = 1; i <= 2; i++) {
            if (game.getPlayers()[i].getNbOfVisCards() == 12) //Need to update visibilty of cards
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Puts the game in starting state.
     */
    public void startGame() {
        if (!game.getStatus().equals(GameState.PRENDREUNECARTE)) {
            throw new IllegalArgumentException("The game is not in starting mode");
        }
        game.setCurrentPlayer();
        game.shuffleDeck();
        game.distribInit();
        for (int i = 1; i <= 2; i++) {
            game.getPlayers()[i].showRandomCardStart();
        }
    }
}
