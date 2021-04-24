package Controller;

import Model.Card;
import Model.Model;
import Model.Player;
import Model.gameState;
import fxLayout.viewInterface;

/**
 * Controller for the game.
 * 
 * @author Gregory
 */
public class Controller {
    
    private final Model game;
    private final viewInterface view;
    
    /**
     * Constructor for controller.
     * @param view View to display game.
     * @param game Model to control game.
     */
    public Controller(viewInterface view, Model game) {
        this.view = view;
        this.game = game;
    }

    /**
     * Starts the whole process of a new game.
     */
    public void start() {
        startGame();
        game.addUtils();
//        while (!over()) {
//            playMove(switchTurn());
//            
//        }
    }

    /**
     * Switches current player
     * @return Player who's turn it switched to.
     */
    public Player switchTurn(){
        return game.nextToPlay();
    }
    
    /**
     * Checks if the game is over.
     * @return True if the game is over.
     */
    public boolean over() {
        return game.getPlayingPlayer() == 2 && allCardVis();
    }
    
    /**
     * Checks if all cards of a player are visible.
     * @return True if all cards are visible.
     */
    public boolean allCardVis(){
        for (int i = 1; i <= 2; i++) 
             if (game.getPlayers()[i].getNbOfVisCards()==12) 
                    return true;
        return false;
    }

    /**
     * Puts the game in starting state.
     */
    public void startGame (){
        if (!game.getStatus().equals(gameState.DEBUT))
            throw new IllegalArgumentException("The game is not in starting mode");
        game.shuffleDeck();
        game.distribInit();
        for (int i = 1; i<=2; i++)
            game.getPlayers()[i].showRandomCardStart();
    }
    
    /**
     * Plays a move of a player. //Play move and apply correct statuses of game.
     * @param player Player that will play move.
     */
    public void playMove(Player player) {
        if(true){
        } else {
            
        }
    }
    
    /**
     * Clicks the thrash pack.
     */
    public void clickTrashPack(){
        game.setTrashPackClicked(true);
    }
    /**
     * Gets the value of the trash pack.
     * @return True if the trash pack is clicked.
     */
    public boolean getTrashPack(){
        return game.isTrashPackClicked();
    }
    
    /**
     * Clicks the draw pack.
     */
    public void clickDrawPack(){
        game.setDrawPackClicked(true);
    }
    /**
     * Gets the value of the draw pack.
     * @return True if the draw pack is clicked.
     */
    public boolean getDrawPack(){
        return game.isDrawPackClicked();
    }
    
    /**
     * Adds current view obs.
     */
    public void addObs(){
        game.registerObs(view);
    }
    
    /**
     * Hits the deck.
     * @return Returns top card.
     */
    public Card hitDeck(){
        return game.getDeck().hitDeck(false);
    }
    
    /**
     * Returns a players card at a specific index.
     * 
     * @param index Index to get card at.
     * @param player Players hand to get card.
     * @return Card at a specific index in a players hand.
     */
    public Card getCardAtIndex (int index, int player){
        return game.getPlayers()[player].getPlayerCardAtIndex(index);
    }
    
    /**
     * Unclicks all buttons.
     */
    public void unclickAll (){
        game.setDrawPackClicked(false);
        game.setTrashPackClicked(false);
    }
    
    /**
     * Changes the state of the game.
     * @param status 
     */
    public void changeGameState(gameState status){
        game.setStatus(status);
    }
    
    /**
     * Getter for the state of the game
     * @return Stage of the current game.
     */
    public gameState getGameState(){
        return this.game.getStatus();
    }
}
