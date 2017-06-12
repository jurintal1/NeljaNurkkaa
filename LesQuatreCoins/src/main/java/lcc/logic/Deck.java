package lcc.logic;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.LinkedList;
import javafx.scene.image.Image;

/**
 * A class for initializing and accessing Deck objects. Deck is represented as
 * LinkedList<Card>.
 */
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

    public Image deckImage() {
        if (this.deck.size() > 0) {
            return this.topCard().getImage();
        } else {
            return null;
        }
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
