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
     * Test of addCard method, of class Player.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card card = new Card(7);
        Player instance = new Player();
        instance.addCard(card);
        assertEquals(card.getValue(), instance.getPlayerCardAtIndex(0).getValue());
    }

}
