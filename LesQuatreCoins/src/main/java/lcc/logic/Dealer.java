package lcc.logic;

import java.util.LinkedList;

/**
 * The class creates and deals cards for manoeuvre decks.
 *
 */
public class Dealer {

    public Dealer() {
    }

    public LinkedList<Card> createLesQuatreCoinsCards() {
        // one set of aces and kings created in Game.createFoundationDecks()
        LinkedList<Card> cards = createCards(1, 13);
        cards.addAll(createCards(2, 12));
        return cards;
    }

    public void deal(Deck[] decks) {
        LinkedList<Card> cards = createLesQuatreCoinsCards();
        while (!cards.isEmpty()) {
            for (Deck deck : decks) {
                if (cards.isEmpty()) {
                    break;
                }
                deck.addCard(cards.pop());
            }
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
