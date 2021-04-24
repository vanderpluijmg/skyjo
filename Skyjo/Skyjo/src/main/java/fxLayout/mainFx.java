package fxLayout;

import Controller.Controller;
import Model.Card;
import Model.Game;
import Model.Player;
import Model.Utils;
import Model.gameState;
import java.util.ArrayList;
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
public class mainFx implements viewInterface{
    
    private Button drawButton;
    private Button trashButton;
    private final Controller controller = new Controller(this, new Game());
    private final GridPane gpL = createPane(10, 5, 5);
    private final GridPane gpM = createPane(10, 5, 5);
    private final GridPane gpR = createPane(10, 5, 5);
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage stage) {
       
        controller.addObs();
        controller.start();
        drawButton = createDrawPack();
        trashButton = createTrashPack();

        //setup
        stage.setTitle("Skyoj");
        VBox vbox = new VBox();
        HBox hbox = new HBox();

        //gridpane left
        //gpL.add(playerTextField(1, game), 0, 0, 4, 1);

        //Gridpane mid
        gpM.add(formatTitles(""), 0, 0, 1, 1);
        gpM.add(formatTitles("Pioche"), 1, 1, 1, 1);
        gpM.add(formatTitles("Défausse"), 1, 3, 1, 1);
        gpM.add(drawButton, 1, 2);
        gpM.add(trashButton, 1, 5);

        //Gridpane right
        //gpR.add(playerTextField(2, game), 0, 0, 4, 1);

        //Adding of elements
        vbox.getChildren().addAll(hbox, formatTitles("Player "
                 + " is allowed to start!"));
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
    private Button createDrawPack() {
        Button button = new Button();
        backFaceCard(button);
        button.setPrefHeight(125);
        button.setPrefWidth(65);
        backFaceCard(button);
        button.setOnAction((var t) -> {
            button.setGraphic(findValue(controller.hitDeck(),button));
            controller.clickDrawPack();
        });
        return button;
    }

    /**
     * Creates the trash pack.
     *
     * @return Formatted button.
     */
    private Button createTrashPack() {
        Button trashPack = new Button();
        trashPack.setPrefHeight(125);
        trashPack.setPrefWidth(65);
        trashPack.setGraphic(findValue(controller.hitDeck(), trashPack));
        trashPack.setStyle("-fx-background-color: transparent;");
        trashPack.setOnAction((var t) -> {
//            if (controller.getTrashPack()){
//                trashButton.setGraphic(drawButton.getGraphic());
//                    playerCard.setGraphic
//                    (findValue(player == 1 ? controller.getCardAtIndex(index, 1)
//                    : controller.getCardAtIndex(index, 2), playerCard));
//            }
            controller.clickTrashPack();
            controller.changeGameState(gameState.ECHANGEdEFAUSSEgRILLE);
        });
        return trashPack;
    }

    /**
     * Creates a grid of cards for player.
     *
     * @param game Model to get cards from.
     * @param col Position of col in grid pane.
     * @param row Position of row in grid pane.
     * @param gp Grid pane to add card to.
     */
    private void displayPlayerGridCards(Player [] players, GridPane gpLeft, GridPane gpRight) {
        for (int row = 1, col = 0, index = 0; row <= 3; col++, index++) {
            Button cardP1 = new Button();
            Button cardP2 = new Button();
            backFaceCard(cardP1);
            backFaceCard(cardP2);
            if (players[1].getPlayerCardAtIndex(index).isVisibiltiy()) {
                cardP1.setGraphic(findValue(players[1].getPlayerCardAtIndex(index), cardP1));
            }
            if (players[2].getPlayerCardAtIndex(index).isVisibiltiy()) {
                cardP2.setGraphic(findValue(players[2].getPlayerCardAtIndex(index), cardP2));
            }
            gridClickable(cardP2, 2, index, players);
            gridClickable(cardP1, 1, index, players);
            gpLeft.add(cardP1, col, row);
            gpRight.add(cardP2, col, row);
            if (col == 3) {
                col = -1;
                row++;
            }
        }
    }
    /**
     * Makes the players grid of card clickable.
     * 
     * @param playerCard Player card to make clickable.
     * @param player Player who the cards belong to.
     * @param index Current index in the building of the grid.
     */
    public void gridClickable(Button playerCard, int player, int index, Player [] players){ 
        playerCard.setOnAction((var t) -> {
            if (player == controller.getPlayerTurn()){
                if (controller.getDrawPack()){
                    playerCard.setGraphic(drawButton.getGraphic());
                    backFaceCard(drawButton);                    
                //make card visible //Add checks for state of game.
                } else if (controller.getTrashPack() && controller.getGameState() == gameState.ECHANGEdEFAUSSEgRILLE){
                    playerCard.setGraphic(trashButton.getGraphic());
                    trashButton.setGraphic(findValue(player == 1 ? controller.getCardAtIndex(index, 1)
                    : controller.getCardAtIndex(index, 2), playerCard));//Gets value of player card.
                } 
                controller.unclickAll();
            }});
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
        btn.setStyle("-fx-background-color: transparent;");
    }

    /**
     * Finds the graphic value of a card and applies it to a button.
     * @param card Card to find graphic value of.
     * @param button Button to add graphic value to.
     * @return ImageView of card.
     */
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
    private TextField updatePlayerTextField(int nb, int totOfPlayer) {
        TextField tf = new TextField("Joueur " + nb + " Points : " 
                + totOfPlayer);
        tf.setAlignment(Pos.CENTER);
        tf.setEditable(false);
        tf.setStyle("-fx-background-color: transparent;");
        return tf;
    }

    @Override
    public void update(Object arg) {
        Utils a = (Utils)arg;
        displayPlayerGridCards(a.getPlayers(), gpL, gpR);
        for (int i = 1; i<2 ; i++)
            updatePlayerTextField(i, a.getPlayers()[i].getNbOFPointsVisCards());
    }
}
