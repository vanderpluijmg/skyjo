package fxLayout;

import Model.Card;
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

        //Cards for both players
        createCardsForPlayers(game, gpL, gpR);

        //gridpane left
        gpL.add(playerTextField(1, game), 0, 0, 4, 1);

        //Gridpane mid
        gpM.add(formatTitles(""), 0, 0, 1, 1);
        gpM.add(formatTitles("Pioche"), 1, 1, 1, 1);
        gpM.add(formatTitles("Poubelle"), 1, 3, 1, 1);
        Button trashPack = createTrashPack(game);
        gpM.add(createDrawPack(game, trashPack), 1, 2);
        gpM.add(trashPack, 1, 5);

        //Gridpane right
        gpR.add(playerTextField(2, game), 0, 0, 4, 1);

        //Adding of elements
        vbox.getChildren().addAll(hbox, formatTitles("Player "
                + game.getFirstToPlay() + " is allowed to start!"));
        hbox.getChildren().addAll(gpL, gpM, gpR);

        //End
        Scene scene = new Scene(vbox, 930, 548);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Formats a title for a deck.
     *
     * @param string String of title
     * @return Text field to add to grid pane.
     */
    private TextField formatTitles(String string) {
        TextField tf = new TextField(string);
        tf.setAlignment(Pos.CENTER);
        tf.setEditable(false);
        tf.setStyle("-fx-background-color: transparent;");
        return tf;
    }

    /**
     * Creates the draw pack for players to be able to draw a new card.
     */
    private Button createDrawPack(Model game, Button tp) {
        Button button = new Button();
        backFaceCard(button);
        button.setPrefHeight(125);
        button.setPrefWidth(65);
        //drawPackClickable(button, tp, game);
        return button;
    }

    /**
     * Creates the trash pack.
     *
     * @return Formatted button.
     */
    private Button createTrashPack(Model game) {
        Button trashPack = new Button();
        trashPack.setPrefHeight(125);
        trashPack.setPrefWidth(65);
        Card card = game.piocheCarte();
        trashPack.setGraphic(findValue(card, trashPack));
        trashPack.setStyle("-fx-background-color: transparent;");
        return trashPack;
    }

    /**
     * Makes the draw pack clickable.
     *
     * @param btn Button to give value to.
     */
    private void drawPackClickable(Button drawPack, Button trashPack, Model game) {
        drawPack.setOnAction((t) -> {
            Card card = game.piocheCarte();
            trashPack.setGraphic(findValue(card, trashPack));
            drawPack.setGraphic(findValue(card, drawPack));
        });
    }

    /**
     * Creates a shape like card.
     *
     * @param game Model to get cards from.
     * @param col Position of col in grid pane.
     * @param row Position of row in grid pane.
     * @param gp Grid pane to add card to.
     */
    private void createCardsForPlayers(Model game, GridPane gpLeft, GridPane gpRight) {
        for (int row = 1, col = 0, index = 0; row <= 3; col++, index++) {
            Button cardP1 = new Button();
            Button cardP2 = new Button();
            backFaceCard(cardP1);
            backFaceCard(cardP2);
            if (game.getPlayers()[1].getPlayerCardAtIndex(index).getVisibiltiy()) {
                cardP1.setGraphic(findValue(game.getPlayers()[1].getPlayerCardAtIndex(index), cardP1));
            }
            if (game.getPlayers()[2].getPlayerCardAtIndex(index).getVisibiltiy()) {
                cardP2.setGraphic(findValue(game.getPlayers()[2].getPlayerCardAtIndex(index), cardP2));
            }
            //eventOfCard(game, cardP1, 1, index);
            gpLeft.add(cardP1, col, row);
            //eventOfCard(game, cardP2, 2, index);
            gpRight.add(cardP2, col, row);
            if (col == 3) {
                col = -1;
                row++;
            }
        }
    }

    /**
     * Creates the back face of a card from a button to make it clickable.
     *
     * @param btn Button from which to create back face.
     */
    private void backFaceCard(Button btn) {
        Image carte = new Image("/backFaceCard.png");
        ImageView cartesIV = new ImageView(carte);
        cartesIV.setFitHeight(125);
        cartesIV.setFitWidth(75);
        btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btn.setGraphic(cartesIV);
        // btn.setStyle("-fx-pref-height: 75px;");
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
    private void eventOfCard(Model game, Button button, int player, int index) {
        Card card = game.getPlayers()[player].getPlayerCardAtIndex(index);
        button.setOnAction((t) -> {
            button.setGraphic(findValue(card, button));
        });
    }

    private ImageView findValue(Card card, Button button) {
        if (card == null || button == null) {
            throw new IllegalArgumentException("Card can't be null");
        }
        Image cartes;
        cartes = switch (card.getValue()) {
            case 1 ->
                new Image("/1.png");
            case 2 ->
                new Image("/2.png");
            case 3 ->
                new Image("/3.png");
            case 4 ->
                new Image("/4.png");
            case 5 ->
                new Image("/5.png");
            case 6 ->
                new Image("/6.png");
            case 7 ->
                new Image("/7.png");
            case 8 ->
                new Image("/8.png");
            case 9 ->
                new Image("/9.png");
            case 10 ->
                new Image("/10.png");
            case 11 ->
                new Image("/11.png");
            case 12 ->
                new Image("/12.png");
            case -2 ->
                new Image("/minus2.png");
            default ->
                new Image("/minus1.png");
        };
        ImageView cartesIV = new ImageView(cartes);
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        return cartesIV;
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
     *
     * @param color Color of text field.
     * @param nb Number of player to display
     * @return TextField correctly formatted.
     */
    private TextField playerTextField(int nb, Model game) {
        TextField tf = new TextField("Joueur " + nb + " Points : " + game.getPlayerTot(nb));
        tf.setAlignment(Pos.CENTER);
        tf.setEditable(false);
        tf.setStyle("-fx-background-color: transparent;");
        return tf;
    }
}
