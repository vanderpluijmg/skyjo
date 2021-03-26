package fxLayout;

import Model.Model;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Layout of front end.
 *
 * @author Gregory
 */
public class mainFx implements viewInterface {

    @Override
    /**
     * {@inheritDoc}
     */
    public void start(Stage stage, Model game) {

        //setup
        stage.setTitle("Skyoj");
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        GridPane gpL = createPane(10, 5, 5);
        GridPane gpM = createPane(10, 5, 5);
        GridPane gpR = createPane(10, 5, 5);

        //vbox
        
        
        //gridpane left
        gpL.add(playerTextField("blue", 1, game), 0, 0, 4, 1);
        //createCardsForPlayers(game, gpL, gpR, 1);

        //Gridpane mid
        TextField textField = new TextField();
        
        
        gpM.add(textField, 0, 0, 2, 1);

        //Gridpane right
        gpR.add(playerTextField("blue", 2, game), 0, 0, 4, 1);

        //Adding of elements
        hbox.getChildren().addAll(gpL, gpM, gpR);

        //End
        Scene scene = new Scene(vbox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Creates the draw pack for players to be able to draw a new card.
     */
    private void createDrawPack (){
        Button button = new Button();
        
    }
    
    /**
     * Creates a shape like card.
     *
     * @param r Rectangle to create.
     * @param col Position of col in grid pane.
     * @param row Position of row in grid pane.
     * @param gp Grid pane to add card to.
     */
    private void createCardsForPlayers(Model game, GridPane gpLeft, GridPane gpRight, int player) {
        for (int row = 1, col = 0, index = 0; row <= 3; col++, index++) {
            Button cardP1 = new Button();
            Button cardP2 = new Button();
            backFaceCard(cardP1);
            backFaceCard(cardP2);
            eventOfCard(game, cardP1, player, index);
            gpLeft.add(cardP1, col, row);
            eventOfCard(game, cardP2, player, index);
            gpRight.add(cardP2, col, row);
            if (col == 3) {
                col = -1;
                row++;
            }
        }
    }

    /**
     * Creates the back face of a card from a button to make it clickable.
     * @param btn Button from which to create back face.
     */
    private void backFaceCard(Button btn) {
        Image carte = new Image("nicubunu_Card_backs_grid_blue.svg");
        ImageView cartes = new ImageView(carte);
        cartes.setFitHeight(100);
        cartes.setFitWidth(50);
        btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btn.setGraphic(cartes);
        btn.setStyle("-fx-pref-height: 75px;");
        btn.setStyle("-fx-background-color: transparent;");
    }

    /**
     * Makes card clickable.
     *
     * @param game Value of cards.
     * @param button Button which represents clickable card.
     * @param player Player of card to flip.
     * @param index Index of card to flip.
     */
    public void eventOfCard(Model game, Button button, int player, int index) {
        button.setOnAction((t) -> {
            button.setText(Integer.toString(game.getPlayers()[player].getPlayerCardAtIndex(index).getValue()));
        });
        button.setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    /**
     * Creates a new grid pane.
     *
     * @param insets Insets value of grid pane.
     * @param Vgap vertical gap of grid pane.
     * @param Hgap horizontal gap of grid pane.
     * @return
     */
    private GridPane createPane(int insets, int Vgap, int Hgap) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(insets));
        gridPane.setHgap(Hgap);
        gridPane.setVgap(Vgap);
        return gridPane;
    }

    /**
     * Create player text field.
     * @param color Color of text field. 
     * @param nb Number of player to display
     * @return TextField correctly formatted.
     */
    private TextField playerTextField(String color, int nb, Model game) {
        TextField tf = new TextField("Joueur " + nb + " Points : " + game.getPlayerTot(nb));
        tf.setAlignment(Pos.CENTER);
        tf.setStyle("-fx-background-color:" + color + ";");
        tf.setEditable(false);
        return tf;
    }
}
