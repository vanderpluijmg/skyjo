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
import javax.swing.JOptionPane;

/**
 * Layout of front end.
 *
 * @author Gregory
 */
public class MainFx implements ViewInterface {

    private Button drawButton;
    private Button trashButton;
    private final Model game;
    private final TextField textFieldInstructions = new TextField("");
    private final TextField pointsRight = new TextField("");
    private final TextField currentPlayer = new TextField("");
    private final TextField pointsLeft = new TextField("");
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
    public void start(Stage primaryStage) {
        game.registerObs(this);
        drawButton = createDrawPack();
        trashButton = createTrashPack();
        updateBegin();
        primaryStage.setTitle("Skyoj");
        HBox hbox = new HBox();
        gpM.add(formatTitles("Pioche"), 1, 1, 1, 1);
        gpM.add(formatTitles("Défausse"), 1, 3, 1, 1);
        gpM.add(drawButton, 1, 2);
        gpM.add(trashButton, 1, 5);
        gpM.add(formatChangeTitles(currentPlayer), 0, 6, 2, 2);
        vbox.getChildren().addAll(hbox, textFieldInstructions);
        hbox.getChildren().addAll(gpL, gpM, gpR);
        gpR.add(formatChangeTitles(pointsRight), 0, 0, 4, 1);
        gpL.add(formatChangeTitles(pointsLeft), 0, 0, 4, 1);
        primaryStage.setScene(new Scene(vbox, 930, 548));
        primaryStage.show();
    }

    /**
     * Formats the text field that are updated during the game.
     *
     * @param tf Text field to format.
     * @return Formatted text field.
     */
    private TextField formatChangeTitles(TextField tf) {
        tf.setMaxWidth(Double.MAX_VALUE);
        tf.setMaxHeight(Double.MAX_VALUE);
        tf.setAlignment(Pos.CENTER);
        tf.setEditable(false);
        tf.setStyle("-fx-background-color: transparent;");
        return tf;
    }

    /**
     * Formats a title for a deck.
     *
     * @param string String of title
     * @return Text field to add to grid pane.
     */
    private TextField formatTitles(String string) {
        TextField tf = new TextField(string);
        tf.setMaxWidth(Double.MAX_VALUE);
        tf.setMaxHeight(Double.MAX_VALUE);
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
                game.notifyDrawPack();
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
                game.notifyTrashPack();
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
                cardP1.setGraphic(findValue(game.getPlayers()[1]
                        .getPlayerCardAtIndex(index), cardP1));
            }
            if (game.getPlayers()[2].getPlayerCardAtIndex(index).isVisibiltiy()) {
                cardP2.setGraphic(findValue(game.getPlayers()[2]
                        .getPlayerCardAtIndex(index), cardP2));
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
                game.cardIsClicked(playerCard, player, index);
            }
        });
    }

    /**
     * Send of pop up with a message and a title.
     *
     * @param message Message to display in popup.
     * @param title Title to display in popup.
     */
    private void popUp(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
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
     * Goes through all the cards to update them.
     *
     * @param playerCard
     * @param player
     * @param index
     */
    public void updateCardGrid(Button playerCard, int player, int index) {
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
            if (game.getPlayers()[player].getPlayerCardAtIndex(index).isVisibiltiy() == true) {
                playerCard.setDisable(true);
                popUp("This card is already visible", "Non valid move");
            } else {
                game.getPlayers()[player].getPlayerCardAtIndex(index).hasVisibility(true);
            }
            playerCard.setGraphic(findValue(game.getPlayers()[player].getPlayerCardAtIndex(index), playerCard));

        }
        playerCard.setDisable(false);
        game.notifyEndOfTurn();
        game.notifyPlayerAndTot(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateInstructions() {
        textFieldInstructions.setAlignment(Pos.CENTER);
        textFieldInstructions.setEditable(false);
        textFieldInstructions.setStyle("-fx-background-color: transparent;");
        switch (game.getStatus()) {
            case ECHANGEdEFAUSSEgRILLE -> {
                textFieldInstructions.setText("Echanger une de vos cartes avec celle de la défausse.");
            }
            case GARDEROUDEFAUSSER -> {
                textFieldInstructions.setText("Veuillez cliquer sur une de vos cartes pour l'echanger ou défausser la carte.");

            }
            case PRENDREUNECARTE -> {
                textFieldInstructions.setText("Prendre une carte sur la pile de défausse ou sur la pioche.");

            }
            case SHOWCARD -> {
                textFieldInstructions.setText("Veuillez cliquez sur une de vos cartes pour la dévoilé.");

            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateScoreAndPlayer(int nb) {
        if (nb == 1) {
            pointsLeft.setText("Joueur " + nb + " Points : "
                    + game.getPlayerTot(nb));
        } else {
            pointsRight.setText("Joueur " + nb + " Points : "
                    + game.getPlayerTot(nb));
        }
        currentPlayer.setText("It is player " + game.getCurrentPlayer()
                + "'s turn");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateDrawDeck() {
        drawButton.setGraphic(findValue(game.getDeck().hitDeck(true),
                drawButton));
        game.setDrawPackClicked(true);
        game.setStatus(GameState.GARDEROUDEFAUSSER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateTrashPack() {
        game.setTrashPackClicked(true);
        game.setStatus(GameState.ECHANGEdEFAUSSEgRILLE);
        if (game.isDrawPackClicked() && game.isTrashPackClicked()) {
            trashButton.setGraphic(findValue(game.getCurrentCard(),
                    trashButton));
            game.setTrashCard(game.getCurrentCard());
            game.setStatus(GameState.SHOWCARD);
            backFaceCard(drawButton);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCards(Button playerCard, int player, int index) {
        updateCardGrid(playerCard, player, index);
    }

    /**
     * Updates that only take place once in the beginning.
     */
    private void updateBegin() {
        displayPlayerGridCards();
        updateInstructions();
        updateScoreAndPlayer(1);
        updateScoreAndPlayer(2);

    }

    /**
     * @{inheritDoc}
     */
    @Override
    public void endOfGame() {
        popUp("Thank you for playing until the end of the game, the winner is player " + game.checkForWinner(), "Game finished!");
        System.exit(0);
    }

}
