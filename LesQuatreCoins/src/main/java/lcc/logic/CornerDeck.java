package lcc.logic;

/**
 *
 * The class represents a deck in a game of Les Quatre Coins, from which cards
 * can be played to foundation decks regardless of suit.
 */
public class CornerDeck extends Deck {

    /**
     * Uses the constructor for Deck.
     */
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

    /**
     * Takes the top card.
     *
     * @return card
     */
    public Card takeCard() {
        if (!this.deck.isEmpty()) {
            return this.deck.pop();
        }
        return null;
    }

}
