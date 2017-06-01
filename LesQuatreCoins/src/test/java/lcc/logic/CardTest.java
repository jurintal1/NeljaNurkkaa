package lcc.logic;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    public CardTest() {
    }   

    @Test
    public void cardConstructorIntegers() {
        Card c = new Card(1, Suit.SPADES);
        assertEquals("ACE OF SPADES", c.toString());
    }

    @Test
    public void cardConstructorConstants() {
        Card c = new Card(Card.JACK, Suit.HEARTS);
        assertEquals("JACK OF HEARTS", c.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cardIllegalValue() {
        Card c = new Card(14, Suit.SPADES);
    }
    
    @Test
    public void valueAsString() {
        Card c = new Card(5, Suit.HEARTS);
        assertEquals("5", c.valueAsString());
    }

    

}
