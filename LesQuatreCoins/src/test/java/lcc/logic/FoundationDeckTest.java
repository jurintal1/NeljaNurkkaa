package lcc.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FoundationDeckTest {

    private FoundationDeck fdUp;
    private FoundationDeck fdDown;
    static Card aceOfSpades;
    static Card twoOfSpades;
    static Card threeOfSpades;
    static Card twoOfHearts;

    public FoundationDeckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        aceOfSpades = new Card(Card.ACE, Suit.SPADES);
        twoOfSpades = new Card(2, Suit.SPADES);
        threeOfSpades = new Card(3, Suit.SPADES);
        twoOfHearts = new Card(2, Suit.HEARTS);

    }

    @Before
    public void setUp() {
        fdUp = new FoundationDeck(Suit.SPADES, Direction.UP);
        fdDown = new FoundationDeck(Suit.SPADES, Direction.DOWN);
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
        fdUp.addCard(twoOfSpades);
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

    @Test
    public void addingTooBig() {
        fdUp.addCard(aceOfSpades);
        assertEquals(false, fdUp.allowedToAdd(threeOfSpades));
    }

    @Test
    public void addingTooSmall() {
        fdUp.addCard(threeOfSpades);
        assertEquals(false, fdUp.allowedToAdd(aceOfSpades));
    }

    @Test
    public void addingWrongSuit() {
        fdUp.addCard(aceOfSpades);
        assertEquals(false, fdUp.allowedToAdd(twoOfHearts));
    }

    @Test
    public void topCard() {
        fdUp.addCard(aceOfSpades);
        fdUp.addCard(twoOfSpades);
        assertEquals(twoOfSpades, fdUp.topCard());
    }

    @Test
    public void takeCard() {
        fdUp.addCard(aceOfSpades);
        fdUp.addCard(twoOfHearts);
        assertEquals(twoOfHearts, fdUp.takeCard());
    }

    @Test
    public void takeCardReducesSize() {
        fdUp.addCard(aceOfSpades);
        fdUp.addCard(twoOfHearts);
        fdUp.takeCard();
        assertEquals(1, fdUp.size());
    }

}
