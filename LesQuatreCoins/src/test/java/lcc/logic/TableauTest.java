package lcc.logic;

import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableauTest {

    private Tableau table;
    private Card aceOfClubs;
    private Card kingOfSpades;

    public TableauTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        this.table = new Tableau();
        this.kingOfSpades = new Card(13, Suit.SPADES);
        this.aceOfClubs = new Card(1, Suit.CLUBS);
    }

    @Test
    public void manoeuvreDecks() {
        for (Deck deck : table.getManoeuvreDecks()) {
            assertEquals(false, deck == null);
        }
    }

    @Test
    public void FoundationDecks() {
        assertEquals(1, table.getClubsDown().size());
        assertEquals(1, table.getClubsUp().size());
        assertEquals(1, table.getDiamondsDown().size());
        assertEquals(1, table.getDiamondsUp().size());
        assertEquals(1, table.getHeartsDown().size());
        assertEquals(1, table.getHeartsUp().size());
        assertEquals(1, table.getSpadesDown().size());
        assertEquals(1, table.getSpadesUp().size());
    }

    @Test
    public void addAcesAndKings() {
        assertEquals("KINGSPADES", table.getSpadesDown().topCard().toString());
        assertEquals("ACECLUBS", table.getClubsUp().topCard().toString());
    }

    @Test
    public void dealToManoeuvreDecks() {
        assertEquals(8, table.getLeft1().size());
        assertEquals(8, table.getRight4().size());
        assertEquals(8, table.getDownRightCorner().size());
    }

    @Test
    public void createManoeuvreDecks() {
        table.createManoeuvreDecks();
        assertEquals(0, table.getRight4().size());
    }

}
