package fxLayout;

import Model.Model;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Layout of front end.
 * @author Gregory
 */
public class mainFx extends Application{
    
    private Model game;
//    public static void main(String[] args) {
//        launch(args);
//    }
    
    @Override
    /**
     * {@inheritDoc}
     */
    public void start(Stage stage) throws Exception {
        //game.distribInit();
        //setup
        stage.setTitle("Skyoj");
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        GridPane gpL = createPane(10, 5, 5);
        GridPane gpM = createPane(10, 5, 5);
        GridPane gpR = createPane(10, 5, 5);
       
        //vbox
        TextField insruction = new TextField("Instruction");
        insruction.setAlignment(Pos.CENTER);
        
        //gridpane left
        for (int row=1, col=0; row<=3; col++){
            createCard(new Rectangle(100, 200), col, row, gpL);
            if (col==3){
                col=-1;
                row++;
            }
        }
        
        //Gridpane mid
        TextField textField = new TextField();
        createCard(new Rectangle(100,200), 1, 1, gpM);
        createCard(new Rectangle(100,200), 1, 2, gpM);
        gpM.add(textField, 0, 0, 2, 1);
                 
        //Gridpane right
        for (int row=1, col=0; row<=3; col++){
            createCard(new Rectangle(100,200), col, row, gpR);
            if (col==3){
                col=-1;
                row++;
            }
        }
        
        //Adding of elements
        vbox.getChildren().addAll(hbox, insruction);
        hbox.getChildren().addAll(gpL, gpM, gpR);
        gpL.add(playerTextField("blue", 1), 0,0,4,1);
        gpR.add(playerTextField("blue", 2), 0,0,4,1);
        
        //End
        Scene scene = new Scene(vbox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Creates a shape like card.
     * @param r Rectangle to create.
     * @param col Position of col in grid pane.
     * @param row Position of row in grid pane.
     * @param gp Grid pane to add card to.
     */
    private void createCard (Rectangle r, int col, int row, GridPane gp){
            r.setX(50);
            r.setY(50);
            r.setArcWidth(20);
            r.setArcHeight(20);
            gp.add(r, col, row);
            
    }
    
    /**
     * Creates a new grid pane.
     * @param insets Insets value of grid pane.
     * @param Vgap vertical gap of grid pane.
     * @param Hgap horizontal gap of grid pane.
     * @return 
     */
    private GridPane createPane (int insets, int Vgap, int Hgap){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(insets));
        gridPane.setHgap(Hgap);
        gridPane.setVgap(Vgap);
        return gridPane;
    }
    
    /**
     * 
     * @param color
     * @param nb
     * @return 
     */
    private TextField playerTextField (String color, int nb){
        TextField tf = new TextField("Joueur " + nb +" Points : ");
        tf.setAlignment(Pos.CENTER);
        tf.setStyle("-fx-background-color:" + color +";");
        tf.setEditable(false);
        return tf;
    }
    
    public void getPlayer(){
        
    }
}