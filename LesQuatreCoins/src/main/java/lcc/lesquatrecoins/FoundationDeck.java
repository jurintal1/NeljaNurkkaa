
package lcc.lesquatrecoins;


public class FoundationDeck extends Deck {
    private String direction;

    public FoundationDeck(int location, String direction) {
        super(location);
        this.direction = direction;
    }   
    

    @Override
    boolean allowedToAdd(Card card) {
        if (this.direction.equalsIgnoreCase("up")
                && card.getValue() - 1 == this.topCard().getValue()
                && card.getSuit() == this.topCard().getSuit()) {
            return true;            
        }
        if (this.direction.equalsIgnoreCase("down")
                && card.getValue() - 1 == this.topCard().getValue()
                && card.getSuit() == this.topCard().getSuit()) {
            return true;            
        }   
        if (card.getValue() + 1 == this.topCard().getValue() 
                        || card.getValue() - 1 == this.topCard().getValue() ) {
            return true;
        }
        return false;
    }
    
}
