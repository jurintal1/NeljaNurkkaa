package lcc.logic;

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
        kingOfClubs = new Card(13, Suit.CLUBS);
        aceOfHearts = new Card(1, Suit.HEARTS);
        twoOfSpades = new Card(2, Suit.SPADES);
    }

    @Before
    public void setUp() {
        cd = new CornerDeck();
    }

    public void startsEmpty() {
        assertEquals(0, cd.size());
    }

    @Test
    public void addingToEmpty() {
        assertEquals(true, cd.allowedToAdd(aceOfHearts));
    }

    @Test
    public void addingAceOnKing() {
        cd.addCard(kingOfClubs);
        assertEquals(true, cd.allowedToAdd(aceOfHearts));
    }

    @Test
    public void addingKingOnAce() {
        cd.addCard(aceOfHearts);
        assertEquals(true, cd.allowedToAdd(kingOfClubs));
    }

    @Test
    public void addingBigger() {
        cd.addCard(aceOfHearts);
        assertEquals(true, cd.allowedToAdd(twoOfSpades));
    }

    @Test
    public void addingSmaller() {
        cd.addCard(twoOfSpades);
        assertEquals(true, cd.allowedToAdd(aceOfHearts));
    }

    @Test
    public void addingTooSmall() {
        cd.addCard(twoOfSpades);
        assertEquals(false, cd.allowedToAdd(kingOfClubs));
    }

    @Test
    public void addingTooBig() {
        cd.addCard(kingOfClubs);
        assertEquals(false, cd.allowedToAdd(twoOfSpades));
    }

    @Test
    public void topCard() {
        cd.addCard(kingOfClubs);
        cd.addCard(twoOfSpades);
        assertEquals(twoOfSpades, cd.topCard());
    }

    @Test
    public void takeCard() {
        cd.addCard(twoOfSpades);
        cd.addCard(aceOfHearts);
        assertEquals(aceOfHearts, cd.takeCard());
    }

    @Test
    public void takeCardReducesSize() {
        cd.addCard(twoOfSpades);
        cd.addCard(aceOfHearts);
        cd.takeCard();
        assertEquals(1, cd.size());
    }

}
