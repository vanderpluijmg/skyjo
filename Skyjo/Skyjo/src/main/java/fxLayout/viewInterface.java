package fxLayout;

import Model.Model;
import javafx.stage.Stage;

/**
 * Interface of view to use in Controller.
 * @author Gregory
 */
public interface viewInterface {
    
    /**
     * Starts a new interface.
     * @param stage Stage to set.
     * @param game Game to play.
     */
    public void start (Stage stage, Model game);
}
