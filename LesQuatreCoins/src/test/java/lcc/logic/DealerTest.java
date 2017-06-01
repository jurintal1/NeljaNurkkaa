package lcc.logic;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DealerTest {

    static Dealer dealer;
    private Deck[] decks;
    private SideDeck sd1;
    private SideDeck sd2;

    public DealerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dealer = new Dealer();

    }

    @Before
    public void setUp() {
        this.sd1 = new SideDeck(Suit.CLUBS);
        this.sd2 = new SideDeck(Suit.CLUBS);
        Deck[] d = {sd1, sd2};
        this.decks = d;

    }

    @Test
    public void createFullDeck() {
        assertEquals(52, dealer.createCards(1, 13).size());
    }

    @Test
    public void createLCCcards() {
        LinkedList cards = dealer.createLesQuatreCoinsCards();
        assertEquals(96, cards.size());
    }

    @Test
    public void dealToTwoDeck() {
        this.dealer.deal(decks);
        assertEquals(48, this.sd1.size());
        assertEquals(48, this.sd2.size());
    }

}
