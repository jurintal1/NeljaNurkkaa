package lcc.logic;

import java.util.LinkedList;

abstract public class Deck {

    protected LinkedList<Card> deck;

    public Deck() {
        this.deck = new LinkedList<>();
    }

    abstract boolean allowedToAdd(Card card);

    public void addCard(Card card) {
        this.deck.push(card);
    }

    public Card topCard() {
        return this.deck.peek();
    }

    public Card takeCard() {
        return this.deck.pop();
    }

    public int size() {
        return this.deck.size();
    }

    @Override
    public String toString() {
        return this.topCard().toString() + " - size " + this.size();
    }

}
