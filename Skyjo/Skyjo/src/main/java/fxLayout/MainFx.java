package fxLayout;

import Model.Card;
import Model.Model;
import Model.GameState;
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
public class MainFx implements ViewInterface {

    private Button drawButton;
    private Button trashButton;
    private Model game;
    private final GridPane gpL = createPane(10, 5, 5);
    private final GridPane gpM = createPane(10, 5, 5);
    private final GridPane gpR = createPane(10, 5, 5);
    private final VBox vbox = new VBox();

    public MainFx(Model model) {
        this.game = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage stage) {
        game.registerObs(this);
        drawButton = createDrawPack();
        trashButton = createTrashPack();

        updateBegin();
        //setup
        stage.setTitle("Skyoj");

        HBox hbox = new HBox();

        //Gridpane mid
        gpM.add(formatTitles("Pioche"), 1, 1, 1, 1);
        gpM.add(formatTitles("Défausse"), 1, 3, 1, 1);
        gpM.add(drawButton, 1, 2);
        gpM.add(trashButton, 1, 5);

        //Adding of elements
        vbox.getChildren().add(hbox);
        hbox.getChildren().addAll(gpL, gpM, gpR);

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
            if (!game.isDrawPackClicked()) {
                game.updateDrawPack();
            }
        });
        return button;
    }

    /**
     * Creates the trash pack.
     *
     * @return Formatted button.
     */
    private Button createTrashPack() {
        game.setTrashCard(game.getDeck().hitDeck(true));
        Button trashPack = new Button();
        trashPack.setPrefHeight(125);
        trashPack.setPrefWidth(65);
        trashPack.setStyle("-fx-background-color: transparent;");
        trashPack.setGraphic(findValue(game.getTrashCard(), trashPack));
        trashPack.setOnAction((var t) -> {
            if (!game.isTrashPackClicked()) {
                game.updateTrashPack();

            }
        });
        return trashPack;
    }

    /**
     * Creates a grid of cards for player.
     */
    private void displayPlayerGridCards() {
        for (int row = 1, col = 0, index = 0; row <= 3; col++, index++) {
            Button cardP1 = new Button();
            Button cardP2 = new Button();
            backFaceCard(cardP1);
            backFaceCard(cardP2);
            if (game.getPlayers()[1].getPlayerCardAtIndex(index).isVisibiltiy()) {
                cardP1.setGraphic(findValue(game.getPlayers()[1].getPlayerCardAtIndex(index), cardP1));
            }
            if (game.getPlayers()[2].getPlayerCardAtIndex(index).isVisibiltiy()) {
                cardP2.setGraphic(findValue(game.getPlayers()[2].getPlayerCardAtIndex(index), cardP2));
            }
            gridClickable(cardP2, 2, index);
            gridClickable(cardP1, 1, index);
            gpL.add(cardP1, col, row);
            gpR.add(cardP2, col, row);
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
    private void gridClickable(Button playerCard, int player, int index) {
        playerCard.setOnAction((var t) -> {
            if (player == game.getCurrentPlayer()) {
                if (game.isDrawPackClicked() && game.getStatus() == GameState.GARDEROUDEFAUSSER) {
                    trashButton.setGraphic(findValue(game.getPlayers()[player].getPlayerCardAtIndex(index), trashButton));
                    playerCard.setGraphic(findValue(game.getCurrentCard(), playerCard));
                    game.getPlayers()[player].switchIndex(index, game.getCurrentCard());
                    backFaceCard(drawButton);
                } else if (game.isTrashPackClicked() && game.getStatus() == GameState.ECHANGEdEFAUSSEgRILLE) {
                    Card playerCards = game.getPlayers()[player].getPlayerCardAtIndex(index);
                    trashButton.setGraphic(findValue(playerCards, trashButton));
                    playerCard.setGraphic(findValue(game.getTrashCard(), playerCard));
                    game.getPlayers()[player].switchIndex(index, game.getTrashCard());
                    game.setTrashCard(playerCards);
                    game.getTrashCard().hasVisibility(true);
                } else if (game.isDrawPackClicked() && game.isTrashPackClicked() && game.getStatus() == GameState.SHOWCARD) {
                    playerCard.setGraphic(findValue(game.getPlayers()[player].getPlayerCardAtIndex(index), playerCard));
                }
                game.setDrawPackClicked(false);
                game.setTrashPackClicked(false);
                game.setStatus(GameState.PRENDREUNECARTE);
                game.updatePlayerAndTot(2);
            }
        });
    }

    ;

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
     *
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
            case 0 ->
                new Image("/0.png");
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
     */
    private void updatePlayerTextField(int nb) {
        TextField tf = new TextField();
        tf.replaceText(0, tf.getText().length() ,"Joueur " + nb + " Points : "
                + game.getPlayerTot(nb));
        tf.setAlignment(Pos.CENTER);
        tf.setEditable(false);
        tf.setStyle("-fx-background-color: transparent;");
        if (nb == 1) {
            gpL.add(tf, 0, 0, 4, 1);
        } else {
            gpR.add(tf, 0, 0, 4, 1);
        }
        gpM.add(formatTitles("It is "+ game.getCurrentPlayer() +"'s" +"turn "), 0, 0, 1, 1);
        
    }

//    /**
//     * Goes through all the cards to update them.
//     */
//    public void updateCardGrid(Button playerCard, int player, int index) {
//            if (game.isDrawPackClicked() && game.getStatus() == GameState.GARDEROUDEFAUSSER) {
//                    trashButton.setGraphic(findValue(game.getPlayers()[player].getPlayerCardAtIndex(index), trashButton));
//                    playerCard.setGraphic(findValue(game.getCurrentCard(), playerCard));
//                    game.getPlayers()[player].switchIndex(index, game.getCurrentCard());
//                    backFaceCard(drawButton);
//                } else if (game.isTrashPackClicked() && game.getStatus() == GameState.ECHANGEdEFAUSSEgRILLE) {
//                    Card playerCards = game.getPlayers()[player].getPlayerCardAtIndex(index);
//                    trashButton.setGraphic(findValue(playerCards, trashButton));
//                    playerCard.setGraphic(findValue(game.getTrashCard(), playerCard));
//                    game.getPlayers()[player].switchIndex(index, game.getTrashCard());
//                    game.setTrashCard(playerCards);
//                    game.getTrashCard().hasVisibility(true);
//                } else if (game.isDrawPackClicked() && game.isTrashPackClicked() && game.getStatus() == GameState.SHOWCARD) {
//                    playerCard.setGraphic(findValue(game.getPlayers()[player].getPlayerCardAtIndex(index), playerCard));
//                }
//                game.setDrawPackClicked(false);
//                game.setTrashPackClicked(false);
//                game.setStatus(GameState.PRENDREUNECARTE);
//               
//                
//    }

    /**
     * Updates the given instruction to the player.
     */
    @Override
    public void updateInstructions() {
        TextField tf = new TextField();
        tf.setText(" ");
        tf.setAlignment(Pos.CENTER);
        tf.setEditable(false);
        tf.setStyle("-fx-background-color: transparent;");
        switch (game.getStatus()) {
            case ECHANGEdEFAUSSEgRILLE -> {
                tf.setText("Echanger une de vos cartes avec celle de la défausse.");
            }
            case GARDEROUDEFAUSSER -> {
                tf.setText("Veuillez cliquer sur une de vos cartes pour l'echanger ou défausser la carte.");

            }
            case PRENDREUNECARTE -> {
                tf.setText("Prendre une carte sur la pile de défausse ou sur la pioche.");

            }
            case SHOWCARD -> {
                tf.setText("Veuillez cliquez sur une de vos cartes pour la dévoilé.");

            }
        }
        vbox.getChildren().add(tf);
    }

    /**
     * Updates the score of both players and the player that is currently playing.
     * @param player
     */
    @Override
    public void updateScoreAndPlayer(int player) {
        updatePlayerTextField(player);
    }

    /**
     * Updates the draw deck.
     */
    @Override
    public void updateDrawDeck() {
        drawButton.setGraphic(findValue(game.getDeck().hitDeck(true), drawButton));
        game.setDrawPackClicked(true);
        game.setStatus(GameState.GARDEROUDEFAUSSER);
        
    }

    /**
     * Updates the trash pack.
     */
    @Override
    public void updateTrashPack() {
        game.setTrashPackClicked(true);
        game.setStatus(GameState.ECHANGEdEFAUSSEgRILLE);
        if (game.isDrawPackClicked() && game.isTrashPackClicked()) {
            trashButton.setGraphic(findValue(game.getCurrentCard(), trashButton));
            game.setTrashCard(game.getCurrentCard());
            game.setStatus(GameState.SHOWCARD);
            backFaceCard(drawButton);
        }
    }

    @Override
    public void updateCards(Button playerCard, int player, int index) {
//        updateCardGrid(playerCard, player, index);
        
    }
    
    private void updateBegin(){
        displayPlayerGridCards();
        updateInstructions();
        updatePlayerTextField(1);        
        updatePlayerTextField(2);

    }

}
