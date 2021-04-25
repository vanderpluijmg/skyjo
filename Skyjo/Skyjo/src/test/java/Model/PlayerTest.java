/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gregory
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getNbOfVisCards method, of class Player.
     */
    @Test
    public void testGetNbOfVisCards() {
        System.out.println("getNbOfVisCards");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getNbOfVisCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbOFPointsVisCards method, of class Player.
     */
    @Test
    public void testGetNbOFPointsVisCards() {
        System.out.println("getNbOFPointsVisCards");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getNbOFPointsVisCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPoints method, of class Player.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        Card card = null;
        Player instance = new Player();
        instance.addPoints(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerCard method, of class Player.
     */
    @Test
    public void testGetPlayerCard() {
        System.out.println("getPlayerCard");
        Player instance = new Player();
        List<Card> expResult = null;
        List<Card> result = instance.getPlayerCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerCardAtIndex method, of class Player.
     */
    @Test
    public void testGetPlayerCardAtIndex() {
        System.out.println("getPlayerCardAtIndex");
        int index = 0;
        Player instance = new Player();
        Card expResult = null;
        Card result = instance.getPlayerCardAtIndex(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class Player.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card card = null;
        Player instance = new Player();
        instance.addCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showRandomCardStart method, of class Player.
     */
    @Test
    public void testShowRandomCardStart() {
        System.out.println("showRandomCardStart");
        Player instance = new Player();
        instance.showRandomCardStart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printHand method, of class Player.
     */
    @Test
    public void testPrintHand() {
        System.out.println("printHand");
        Player instance = new Player();
        instance.printHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
