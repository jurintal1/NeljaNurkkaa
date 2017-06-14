package lcc.logic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * The class creates and deals cards for manoeuvre decks.
 *
 */
public class Dealer {

    public Dealer() {
    }

    /**
     * Deals the LCC cards to defined decks.
     *
     * @param decks
     */
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

    /**
     * Creates and shuffles the cards for LCC. One set of aces and kings is
     * created in Tableau.createFoundationDecks().
     *
     * @return return the necessary cards as LinkedList.
     */
    public LinkedList<Card> createLesQuatreCoinsCards() {
        // 
        LinkedList<Card> cards = createCards(1, 13);
        cards.addAll(createCards(2, 12));
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
        return cards;
    }

    /**
     * Creates Card objects between the defined values.     *
     * @param minValue
     * @param maxValue
     * @return Returns the cards as LinkedList.
     */
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
