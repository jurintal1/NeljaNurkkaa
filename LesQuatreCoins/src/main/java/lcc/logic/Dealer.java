
package lcc.logic;

import java.util.LinkedList;


public class Dealer {

    public Dealer() {
    }
    
    public void deal(Deck[] decks) {
        // one set of aces and kings created in Game.createFoundationDecks()
        LinkedList<Card> cards = createCards(1, 13);
        cards.addAll(createCards(2,12));
        for (Deck deck : decks) {
            if (cards.isEmpty()) {
                break;
            }
            deck.addCard(cards.pop());
        }      
        
    }
    
    public LinkedList createCards(int minValue, int maxValue) {
        LinkedList<Card> cards = new LinkedList();
        for (int i = minValue; i <= maxValue; i++) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(i, suit));
            }
        }
        return cards;
    }
    
    
    
    
}
