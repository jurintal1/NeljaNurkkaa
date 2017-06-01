
package lcc.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CornerDeckTest {
    
    public CornerDeckTest() {
    }
    
    
    private CornerDeck cd;
    static Card kingOfClubs;
    static Card aceOfHearts;
    static Card twoOfSpades;
    
    
    @BeforeClass
    public static void setUpClass() {
        kingOfClubs = new Card(13,Suit.CLUBS);
        aceOfHearts = new Card(1, Suit.HEARTS);
        twoOfSpades = new Card(2, Suit.SPADES);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cd = new CornerDeck();
    }
    
    @After
    public void tearDown() {
    }
    
    public void startsEmpty() {
        assertEquals(0, cd.size());
    }

    @Test
    public void addingToEmptyAllowed() {        
        assertEquals(true, cd.allowedToAdd(aceOfHearts));
    }
    
    @Test
    public void addingAceOnKingAllowed() {
        cd.addCard(kingOfClubs);
        assertEquals(true, cd.allowedToAdd(aceOfHearts));
    }
    
    @Test
    public void addingKingOnAceAllowed() {
        cd.addCard(aceOfHearts);
        assertEquals(true, cd.allowedToAdd(kingOfClubs));
    }
    
    @Test
    public void addingTwoOnAceAllowed() {
        cd.addCard(aceOfHearts);
        assertEquals(true, cd.allowedToAdd(twoOfSpades));
    }
    
    @Test
    public void addingAceOnTwoNotAllowed() {
        cd.addCard(twoOfSpades);
        assertEquals(true, cd.allowedToAdd(aceOfHearts));
    }
    
    
    
    

}
