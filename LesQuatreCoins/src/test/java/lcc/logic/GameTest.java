package lcc.logic;

import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameTest {
    private Game game;
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
   
    
    @Before
    public void setUp() {
        this.game = new Game();
    }
   
    @Test
    public void manoeuvreDecks() {
        game.createManoeuvreDecks();
        for (Deck deck: game.getManoeuvreDecks()) {
            assertEquals(false, deck==null);
        }
    }
    
    
    
    
    
    

}
