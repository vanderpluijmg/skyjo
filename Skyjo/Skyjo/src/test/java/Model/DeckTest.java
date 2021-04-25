/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gregory
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of shuffleDeck method, of class Deck.
     */
    @Test
    public void testShuffleDeck() {
        System.out.println("shuffleDeck");
        Deck instance = new Deck();
        instance.shuffleDeck();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLast method, of class Deck.
     */
    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        Deck instance = new Deck();
        Card expResult = null;
        Card result = instance.removeLast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hitDeck method, of class Deck.
     */
    @Test
    public void testHitDeck() {
        System.out.println("hitDeck");
        boolean show = false;
        Deck instance = new Deck();
        Card expResult = null;
        Card result = instance.hitDeck(show);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Deck.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Deck instance = new Deck();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Deck.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Deck instance = new Deck();
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
