package lcc.lesquatrecoins;

import java.util.LinkedList;

abstract public class Deck {
    protected int location;
    protected LinkedList<Card> deck;

    public Deck(int location) {
        this.deck = new LinkedList<Card>();        
    }    
        
    abstract boolean allowedToAdd(Card card);
    
    public boolean addCard(Card card){
        if (this.allowedToAdd(card)) {
            this.deck.push(card);
        return true;
        }
        return false;
    }
    
    public Card topCard() {
        return this.deck.peek();
    }
    
    
    
    
     
}
