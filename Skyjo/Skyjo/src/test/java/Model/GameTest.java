package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gregory
 */
public class GameTest {

    public GameTest() {
    }

    /**
     * Test of getStatus method, of class Game.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Game instance = new Game();
        instance.setStatus(GameState.GARDEROUDEFAUSSER);
        GameState expResult = GameState.GARDEROUDEFAUSSER;
        GameState result = instance.getStatus();
        assertEquals(expResult, result);
    }


    /**
     * Test of piocheCarte method, of class Game.
     */
    @Test
    public void testPiocheCarte() {
        System.out.println("piocheCarte");
        Game instance = new Game();
        Deck deck = instance.getDeck();
        Card expResult = deck.removeLast();
        expResult.hasVisibility(true);
        Card result = instance.piocheCarte();
        assertEquals(expResult.getValue(), result.getValue());
    }

    /**
     * Test of distribInit method, of class Game.
     */
    @Test
    public void testDistribInit() {
        System.out.println("distribInit");
        Game instance = new Game();
        instance.distribInit();
        int i =0;
        while (!instance.getDeck().isEmpty()){
            i++;
            instance.getDeck().removeLast();
        }
        assertEquals(i, 126);
    }

    /**
     * Test of nextToPlay method, of class Game.
     */
    @Test
    public void testNextToPlay() {
        System.out.println("nextToPlay");
        Game instance = new Game();
        int expResult = instance.getCurrentPlayer();
        instance.nextToPlay();
        int result = instance.getCurrentPlayer();
        assertNotEquals(expResult, result);
    }


    /**
     * Test of getCurrentPlayer method, of class Game.
     */
    @Test
    public void testGetPlayingPlayer() {
        System.out.println("getPlayingPlayer");
        int expResult;
        Game instance = new Game();
        if (instance.getPlayers()[1].getNbOFPointsVisCards() >= instance.getPlayers()[2].getNbOFPointsVisCards())
            expResult = 1;
        else expResult = 2;
        int result = instance.getCurrentPlayer();
        System.out.println(result);
        System.out.println(expResult);      
        assertEquals(expResult, result);
    }


    /**
     * Test of setTrashPackClicked and isTrashPackClicked method, of class Game.
     */
    @Test
    public void testSetTrashPackClicked() {
        System.out.println("setTrashPackClicked");
        boolean trashPackClicked = false;
        Game instance = new Game();
        instance.setTrashPackClicked(trashPackClicked);
        assertEquals(trashPackClicked, instance.isTrashPackClicked());
    }

   
    /**
     * Test of setDrawPackClicked and isDrawPackClicked methods, of class Game.
     */
    @Test
    public void testSetDrawPackClicked() {
        System.out.println("setDrawPackClicked");
        boolean drawPackClicked = false;
        Game instance = new Game();
        instance.setDrawPackClicked(drawPackClicked);
        assertEquals(drawPackClicked, instance.isDrawPackClicked());
    }

}
