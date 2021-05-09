package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gregory
 */
public class CardTest {

    public CardTest() {
    }

    /**b
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Card instance = new Card (7);
        int expResult = 7;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of isVisibiltiy method, of class Card.
     */
    @Test
    public void testIsVisibiltiy() {
        System.out.println("isVisibiltiy");
        Card instance = new Card (7);
        boolean expResult = false;
        boolean result = instance.isVisibiltiy();
        assertEquals(expResult, result);
    }
}
