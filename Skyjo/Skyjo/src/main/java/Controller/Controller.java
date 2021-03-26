package Controller;

import Model.Model;
import fxLayout.viewInterface;
import javafx.stage.Stage;

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
     * @param stage Stage to display in fx.
     */
    public void start(Stage stage) {
        game.shuffleDeck();
        game.distribInit();
        for (int i = 1; i<=2; i++)
            game.getPlayers()[i].showRandomCardStart();
        view.start(stage, game);
    }
}
