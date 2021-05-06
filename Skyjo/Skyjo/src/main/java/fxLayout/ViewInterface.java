package fxLayout;

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
     * Updates the draw deck with new information from model.
     */
    public void updateDrawDeck();

    /**
     * Updates the card grid with new information from model.
     *
     * @param playerCard Card to update.
     * @param player Player that clicked card.
     * @param index Specific index of clicked card.
     */
    public void updateCards(Button playerCard, int player, int index);

    /**
     * Updates the instructions with new information from model.
     */
    public void updateInstructions();

    /**
     * Updates the score and current player with new information from model.
     *
     * @param player Player to update score from.
     */
    public void updateScoreAndPlayer(int player);

    /**
     * Updates the trash deck with new information from model.
     */
    public void updateTrashPack();

    /**
     * Display the end of the game popup.
     */
    public void endOfGame();
}
