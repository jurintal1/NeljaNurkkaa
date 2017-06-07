
package lcc.logic;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameplayTest {
    static Game gp;
    static FoundationDeck fdSpadesUp;
    static FoundationDeck fdHeartsUp;
    static SideDeck sdSpades;
    static SideDeck sdHeart;    
    static Card aceOfSpades;
    static Card twoOfSpades;
    static Card aceOfHearts;
    static CornerDeck cd;
    
    
    public GameplayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        gp = new Game();
        fdSpadesUp = new FoundationDeck(Suit.SPADES, Direction.UP);
        fdHeartsUp = new FoundationDeck(Suit.HEARTS, Direction.UP);
        aceOfSpades = new Card(1, Suit.SPADES);
        twoOfSpades = new Card(2, Suit.SPADES);
        aceOfHearts = new Card(1, Suit.HEARTS);
        sdSpades = new SideDeck(Suit.SPADES);
        cd = new CornerDeck();
        // tee tässä loputkin!
    }
    
    
    @Before
    public void setUp() {
         
    }
    
    @Test   
    public void moveFromSideToFoundation() {
        sdSpades.addCard(twoOfSpades);
        fdSpadesUp.addCard(aceOfSpades);
        assertEquals(true, gp.move(sdSpades, fdSpadesUp));
   
    }
    
    @Test
    public void moveFromSideToWrongFoundation() {
        sdSpades.addCard(twoOfSpades);  
        fdHeartsUp.addCard(aceOfHearts);        
        assertEquals(false, gp.move(sdSpades, fdHeartsUp));
    }
    

}
