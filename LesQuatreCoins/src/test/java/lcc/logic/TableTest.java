package lcc.logic;

import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TableTest {
    private Table table;
    private Card aceOfClubs;
    private Card kingOfSpades;
    
    public TableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
   
    
    @Before
    public void setUp() {
        this.table = new Table();
        this.kingOfSpades = new Card(13, Suit.SPADES);
        this.aceOfClubs = new Card(1, Suit.CLUBS);
    }
   
    @Test
    public void manoeuvreDecks() {
        table.createManoeuvreDecks();
        for (Deck deck: table.getManoeuvreDecks()) {
            assertEquals(false, deck==null);
        }
    }
    
    @Test
    public void addAcesAndKings() {
        table.createManoeuvreDecks();
        table.addAcesAndKingsToFoundationDecks();
        assertEquals("KINGSPADES", table.getSpadesDown().topCard().toString());
        assertEquals("ACECLUBS", table.getClubsUp().topCard().toString());
    }
    
    @Test
    public void dealToManoeuvreDecks() {
        table.createManoeuvreDecks();
        table.dealToManoeuvreDecks(); 
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
