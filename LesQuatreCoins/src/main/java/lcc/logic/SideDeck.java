/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcc.logic;

/**
 *
 * @author o
 */
public class SideDeck extends Deck {
    private Suit suit;

    public SideDeck(Suit suit) {
        super();    
        this.suit = suit;
    }

    @Override
    boolean allowedToAdd(Card card) {
        if ((card.getValue() + 1) % 13 == this.topCard().getValue()
                || (card.getValue() - 1) % 13 == this.topCard().getValue()) {
            return true;
        }
        return false;
    }

    public Suit getSuit() {
        return suit;
    }

}
