package Main;

import fxLayout.mainFx;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 * Main class of Skyjo.
 *
 * @author Gregory
 */
public class Main extends Application {

    /**
     * Main function of main class. Launches fx.
     *
     * @param args Arguments to launch fx.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage stage) throws Exception {
        mainFx mainFx = new mainFx();
        mainFx.start(stage);
    }
}
