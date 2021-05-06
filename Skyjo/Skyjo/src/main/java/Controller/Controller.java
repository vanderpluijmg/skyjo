package Controller;

import Model.Game;
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
     */
    public Controller() {
        game = new Game();
        this.view = new MainFx(game);
    }

    /**
     * Starts the whole process of a new game.
     * @param stage Stage to display.
     */
    public void startView(Stage stage) {
        startGame();
        view.start(stage);
    }

    /**
     * Puts the game in starting state.
     */
    public void startGame() {
        if (!game.getStatus().equals(GameState.PRENDREUNECARTE)) {
            throw new IllegalArgumentException("The game is not in starting mode");
        }
        game.shuffleDeck();
        game.distribInit();
        for (int i = 1; i <= 2; i++) {
            game.getPlayers()[i].showRandomCardStart();
        }
        game.setCurrentPlayer();
    }
}
