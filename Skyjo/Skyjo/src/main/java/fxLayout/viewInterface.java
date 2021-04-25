package fxLayout;

import Model.Model;
import javafx.stage.Stage;

/**
 * Interface of view to use in Controller.
 *
 * @author Gregory
 */
public interface viewInterface {

    /**
     * Starts a new interface.
     *
     * @param stage Stage to set.
     */
    public void start(Stage stage);
    
    /**
     * Updates the view with new information from model.
     * @param arg Object used to update view.
     */
    public void update(Object arg);
    
}
