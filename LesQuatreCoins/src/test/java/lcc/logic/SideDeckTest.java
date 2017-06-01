package lcc.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SideDeckTest {

    private SideDeck sd;
    static Card aceOfClubs;
    static Card twoOfHearts;
    static Card kingOfSpades;

    public SideDeckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        aceOfClubs = new Card(1, Suit.CLUBS);
        twoOfHearts = new Card(2, Suit.HEARTS);
        kingOfSpades = new Card(13, Suit.SPADES);
    }

    @Before
    public void setUp() {
        this.sd = new SideDeck(Suit.CLUBS);
    }

    public void startsEmpty() {
        assertEquals(0, sd.size());
    }

    @Test
    public void notAllowedToAddToEmpty() {
        assertEquals(false, sd.allowedToAdd(aceOfClubs));
    }

    @Test
    public void addingAceOnKing() {
        sd.addCard(kingOfSpades);
        assertEquals(true, sd.allowedToAdd(aceOfClubs));
    }

    @Test
    public void addingKingOnAce() {
        sd.addCard(aceOfClubs);
        assertEquals(true, sd.allowedToAdd(kingOfSpades));
    }

    @Test
    public void addingBigger() {
        sd.addCard(aceOfClubs);
        assertEquals(true, sd.allowedToAdd(twoOfHearts));
    }

    @Test
    public void addingSmaller() {
        sd.addCard(twoOfHearts);
        assertEquals(true, sd.allowedToAdd(aceOfClubs));
    }

    @Test
    public void addingTooSmall() {
        sd.addCard(twoOfHearts);
        assertEquals(false, sd.allowedToAdd(twoOfHearts));
    }

    @Test
    public void addingTooBig() {
        sd.addCard(kingOfSpades);
        assertEquals(false, sd.allowedToAdd(twoOfHearts));
    }

    @Test
    public void topCard() {
        sd.addCard(kingOfSpades);
        sd.addCard(twoOfHearts);
        assertEquals(twoOfHearts, sd.topCard());
    }

    @Test
    public void takeCard() {
        sd.addCard(twoOfHearts);
        sd.addCard(aceOfClubs);
        assertEquals(aceOfClubs, sd.takeCard());
    }

    @Test
    public void takeCardReducesSize() {
        sd.addCard(aceOfClubs);
        sd.addCard(kingOfSpades);
        sd.takeCard();
        assertEquals(1, sd.size());
    }

}
