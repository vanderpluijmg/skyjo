package Model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gregory
 */
public class PlayerTest {

    public PlayerTest() {
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
        }

    /**
     * Test of addPoints method, of class Player.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        Card card = new Card(7);
        card.hasVisibility(true);
        Player instance = new Player();
        instance.addPoints(card);
        assertEquals(7, instance.getNbOFPointsVisCards());
        
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

}
