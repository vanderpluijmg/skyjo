package fxLayout;

import Model.Model;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Interface of view to use in Controller.
 *
 * @author Gregory
 */
public interface ViewInterface {

    /**
     * Starts a new interface.
     *
     * @param stage Stage to set.
     */
    public void start(Stage stage);

    /**
     * Updates the view with new information from model.
     */
    public void updateDrawDeck();
    
    public void updateCards(Button playerCard, int player, int index);
    
    public void updateInstructions();
    
    public void updateScoreAndPlayer(int player);
    
    public void updateTrashPack();

}
