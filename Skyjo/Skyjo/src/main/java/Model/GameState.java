package Model;

/**
 * Keeps track of the current state of the game. Game can be in 5 different
 * states.
 *
 * @author Gregory
 */
public enum GameState {
    PRENDREUNECARTE, //User must take a card.
    GARDEROUDEFAUSSER, //User must keep or throw card in trash.
    ECHANGEdEFAUSSEgRILLE, //User must exchange card of trash with grid.
    SHOWCARD, //User must show one of his cards.
    ENDOFGAME //End of the game.
}
