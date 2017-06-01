package lcc.logic;

import lcc.logic.Card;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    public CardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void CardConstructorIntegers() {
        Card c = new Card(1, Suit.SPADES);
        assertEquals("ACE OF SPADES", c.toString());
    }

    @Test
    public void CardConstructorConstants() {
        Card c = new Card(Card.JACK, Suit.HEARTS);
        assertEquals("JACK OF HEARTS", c.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void CardIllegalValue() {
        Card c = new Card(14, Suit.SPADES);
    }

    

}
