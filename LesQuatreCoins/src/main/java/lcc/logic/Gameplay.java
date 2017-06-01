package lcc.logic;

public class Gameplay { 
    
    
    
    public boolean move(Deck source, Deck destination) {
        if (source == destination || source instanceof FoundationDeck 
                || !destination.allowedToAdd(source.topCard())) {
            return false;
        }
        destination.addCard(source.takeCard());
        return true; 
    }
    
    public boolean move(SideDeck source, FoundationDeck destination) {
        if (source.getSuit()==destination.getSuit()
                && destination.allowedToAdd(source.topCard())) {
            destination.addCard(source.takeCard());
            return true;
        }        
        return false; 
    }
    
    
    
    

}
