
package lcc.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameplayTest {
    static Gameplay gp;
    static FoundationDeck fdSpadesUp;
    static SideDeck sdSpades;
    static SideDeck sdHeart;
    static Card aceOfSpades;
    static Card twoOfSpades;
    
    
    public GameplayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        gp = new Gameplay();
        fdSpadesUp = new FoundationDeck(Suit.SPADES, Direction.UP);
        aceOfSpades = new Card(1, Suit.SPADES);
        twoOfSpades = new Card(2, Suit.SPADES);
        // tee tässä loputkin!
    }
    
    
    @Before
    public void setUp() {
         
    }
    
//    @Test   EI TOIMI VIELÄ
//    public void moveFromSideToFoundation() {
//        sdSpades.addCard(twoOfSpades);
//        fdSpadesUp.addCard(aceOfSpades);
//        assertEquals(true, gp.move(sdSpades, fdSpadesUp));       
//    
//    }
    

}
