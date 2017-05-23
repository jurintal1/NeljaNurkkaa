/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lcc.lesquatrecoins.Card;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author o
 */
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
        Card c = new Card(1, 3);
        assertEquals("ACE OF SPADES", c.toString());
    }

    @Test
    public void CardConstructorConstants() {
        Card c = new Card(Card.JACK, Card.HEARTS);
        assertEquals("JACK OF HEARTS", c.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void CardIllegalValue() {
        Card c = new Card(14, Card.CLUBS);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void CardIllegalSuit() {
        Card c = new Card(13, 5);
    }
    
    
}


