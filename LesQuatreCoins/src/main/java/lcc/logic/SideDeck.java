package lcc.logic;

/**
 *
 * The class represent a deck in game on Les Quatre Coins, from which cards can
 * be built to FoundationDeck of same suit.
 */
public class SideDeck extends Deck {

    private Suit suit;

    public SideDeck(Suit suit) {
        super();
        this.suit = suit;
    }

    @Override
    boolean allowedToAdd(Card card) {
        if (this.deck.isEmpty()) {
            return false;
        }
        if ((card.getValue() + 1) % 13 == this.topCard().getValue() % 13
                || (card.getValue() - 1) % 13 == this.topCard().getValue() % 13) {
            return true;
        }
        return false;
    }

    public Suit getSuit() {
        return suit;
    }

}
