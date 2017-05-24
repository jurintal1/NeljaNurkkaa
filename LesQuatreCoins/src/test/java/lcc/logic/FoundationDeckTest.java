package lcc.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FoundationDeckTest {

    static FoundationDeck fdUp;
    static FoundationDeck fdDown;
    static Card aceOfSpades;
    static Card twoOfSpades;

    public FoundationDeckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        fdUp = new FoundationDeck(0, "up");
        fdDown = new FoundationDeck(0, "down");
        aceOfSpades = new Card(Card.ACE, Card.SPADES);
        twoOfSpades = new Card(2, Card.SPADES);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, fdUp.size());
    }

    @Test
    public void addingToEmptyAllowed() {        
        assertEquals(true, fdUp.allowedToAdd(twoOfSpades));
    }

    
    @Test
    public void addingBiggerToUp() {
        fdUp.addCard(aceOfSpades);
        assertEquals(true, fdUp.allowedToAdd(twoOfSpades));
    }
    
    @Test
    public void addingSmallerToUp() {
        fdDown.addCard(twoOfSpades);
        assertEquals(false, fdUp.allowedToAdd(aceOfSpades));
    }
    
    @Test
    public void addingSmallerToDown() {
        fdDown.addCard(twoOfSpades);
        assertEquals(true, fdDown.allowedToAdd(aceOfSpades));
    }
    
    @Test
    public void addingBiggerToDown() {
        fdDown.addCard(aceOfSpades);
        assertEquals(false, fdDown.allowedToAdd(twoOfSpades));
    }
    
    
    
    
    
    

    @Test
    public void addingOne() {
        fdUp.addCard(aceOfSpades);
        assertEquals(1, fdUp.size());
    }

    
}
