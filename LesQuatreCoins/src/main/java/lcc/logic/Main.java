package lcc.logic;

public class Main {

    public static void main(String[] args) {
     SideDeck sdSpades = new SideDeck(Suit.SPADES);
     FoundationDeck fdHeartsUp = new FoundationDeck(Suit.HEARTS, Direction.UP);
     Card twoOfSpades = new Card(2, Suit.SPADES);
     Card aceOfHearts = new Card(1, Suit.HEARTS);   
     sdSpades.addCard(twoOfSpades);  
     fdHeartsUp.addCard(aceOfHearts);        
     
        

    }
}
