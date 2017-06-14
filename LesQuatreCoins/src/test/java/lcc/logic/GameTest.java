
package lcc.logic;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameTest {
    static Rules gp;
    static FoundationDeck fdSpadesUp;
    static FoundationDeck fdHeartsUp;
    static SideDeck sdSpades;
    static SideDeck sdHeart;    
    static Card aceOfSpades;
    static Card twoOfSpades;
    static Card aceOfHearts;
    static CornerDeck cd;
    
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        gp = new Rules();
        fdSpadesUp = new FoundationDeck(Suit.SPADES, Direction.UP);
        fdHeartsUp = new FoundationDeck(Suit.HEARTS, Direction.UP);
        aceOfSpades = new Card(1, Suit.SPADES);
        twoOfSpades = new Card(2, Suit.SPADES);
        aceOfHearts = new Card(1, Suit.HEARTS);
        twoOfSpades = new Card(2, Suit.SPADES);
        sdSpades = new SideDeck(Suit.SPADES);
        sdHeart = new SideDeck(Suit.HEARTS);
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
    public void FoundationGrows() {
        sdSpades.addCard(twoOfSpades);
        fdSpadesUp.addCard(aceOfSpades);
        gp.move(sdSpades, fdSpadesUp);
        assertEquals(2, fdSpadesUp.size());
   
    }
    
    @Test
    public void moveFromSideToWrongFoundation() {
        sdSpades.addCard(twoOfSpades);  
        fdHeartsUp.addCard(aceOfHearts);        
        assertEquals(false, gp.move(sdSpades, fdHeartsUp));
    }
    
    @Test public void moveFromSideToSide() {
        sdSpades.addCard(aceOfSpades);
        sdHeart.addCard(twoOfSpades);
        gp.move(sdSpades, sdHeart);
        assertEquals(2, sdHeart.size());
        
    }
    

}
