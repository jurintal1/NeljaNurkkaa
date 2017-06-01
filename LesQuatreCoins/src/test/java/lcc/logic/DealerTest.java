/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcc.logic;

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
    public void dealToTwoDeck() {
        dealer.deal(decks);
        assertEquals(48, this.sd1.size());
        assertEquals(48, this.sd2.size());
    }

}

