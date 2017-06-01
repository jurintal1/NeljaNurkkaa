/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcc.logic;

public class CornerDeck extends Deck {

    public CornerDeck() {
        super();
    }

    @Override
    boolean allowedToAdd(Card card) {
        if (this.deck.isEmpty()) {
            return true;
        }
        if ((card.getValue() + 1) % 13 == this.topCard().getValue() % 13
                || (card.getValue() - 1) % 13 == this.topCard().getValue() % 13) {
            return true;
        }
        return false;
    }

    public Card takeCard() {
        if (!this.deck.isEmpty()) {
            return this.deck.pop();
        }
        return null;
    }

}
