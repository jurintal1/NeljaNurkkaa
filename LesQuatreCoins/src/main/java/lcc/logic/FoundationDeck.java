
package lcc.logic;


public class FoundationDeck extends Deck {
    private Direction direction;
    private Suit suit;

    public FoundationDeck(Suit suit, Direction direction) {
        super();        
        this.direction = direction;
        this.suit = suit;        
    }   
    

    @Override
    boolean allowedToAdd(Card card) {
        if (this.deck.isEmpty()) {
            return true;
        }
        if (this.direction==Direction.UP
                && card.getValue() - 1 == this.topCard().getValue()
                && card.getSuit() == this.topCard().getSuit()) {
            return true;            
        }
        if (this.direction==Direction.DOWN
                && card.getValue() + 1 == this.topCard().getValue()
                && card.getSuit() == this.topCard().getSuit()) {
            return true;            
        }         
        return false;
    }

    public Direction getDirection() {
        return direction;
    }

    public Suit getSuit() {
        return suit;
    }
    
    
    
}
