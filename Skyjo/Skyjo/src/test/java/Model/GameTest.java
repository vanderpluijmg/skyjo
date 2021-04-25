/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import fxLayout.viewInterface;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gregory
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getStatus method, of class Game.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Game instance = new Game();
        gameState expResult = null;
        gameState result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Game.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        gameState status = null;
        Game instance = new Game();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffleDeck method, of class Game.
     */
    @Test
    public void testShuffleDeck() {
        System.out.println("shuffleDeck");
        Game instance = new Game();
        instance.shuffleDeck();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class Game.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Game instance = new Game();
        Player[] expResult = null;
        Player[] result = instance.getPlayers();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of piocheCarte method, of class Game.
     */
    @Test
    public void testPiocheCarte() {
        System.out.println("piocheCarte");
        Game instance = new Game();
        Card expResult = null;
        Card result = instance.piocheCarte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showCard method, of class Game.
     */
    @Test
    public void testShowCard() {
        System.out.println("showCard");
        Card card = null;
        Game instance = new Game();
        instance.showCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerTot method, of class Game.
     */
    @Test
    public void testGetPlayerTot() {
        System.out.println("getPlayerTot");
        int p = 0;
        Game instance = new Game();
        String expResult = "";
        String result = instance.getPlayerTot(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distribInit method, of class Game.
     */
    @Test
    public void testDistribInit() {
        System.out.println("distribInit");
        Game instance = new Game();
        instance.distribInit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printDeck method, of class Game.
     */
    @Test
    public void testPrintDeck() {
        System.out.println("printDeck");
        Game instance = new Game();
        instance.printDeck();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextToPlay method, of class Game.
     */
    @Test
    public void testNextToPlay() {
        System.out.println("nextToPlay");
        Game instance = new Game();
        Player expResult = null;
        Player result = instance.nextToPlay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObs method, of class Game.
     */
    @Test
    public void testRegisterObs() {
        System.out.println("registerObs");
        viewInterface obs = null;
        Game instance = new Game();
        instance.registerObs(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObs method, of class Game.
     */
    @Test
    public void testNotifyObs() {
        System.out.println("notifyObs");
        Object arg = null;
        Game instance = new Game();
        instance.notifyObs(arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUtils method, of class Game.
     */
    @Test
    public void testAddUtils() {
        System.out.println("addUtils");
        Game instance = new Game();
        instance.addUtils();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayingPlayer method, of class Game.
     */
    @Test
    public void testGetPlayingPlayer() {
        System.out.println("getPlayingPlayer");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getPlayingPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTrashPackClicked method, of class Game.
     */
    @Test
    public void testIsTrashPackClicked() {
        System.out.println("isTrashPackClicked");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isTrashPackClicked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTrashPackClicked method, of class Game.
     */
    @Test
    public void testSetTrashPackClicked() {
        System.out.println("setTrashPackClicked");
        boolean trashPackClicked = false;
        Game instance = new Game();
        instance.setTrashPackClicked(trashPackClicked);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDrawPackClicked method, of class Game.
     */
    @Test
    public void testIsDrawPackClicked() {
        System.out.println("isDrawPackClicked");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isDrawPackClicked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDrawPackClicked method, of class Game.
     */
    @Test
    public void testSetDrawPackClicked() {
        System.out.println("setDrawPackClicked");
        boolean drawPackClicked = false;
        Game instance = new Game();
        instance.setDrawPackClicked(drawPackClicked);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeck method, of class Game.
     */
    @Test
    public void testGetDeck() {
        System.out.println("getDeck");
        Game instance = new Game();
        Deck expResult = null;
        Deck result = instance.getDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
