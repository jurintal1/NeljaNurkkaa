package lcc.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 * A class for initializing and accessing Deck objects. A deck of cards is
 * represented as LinkedList.
 */
abstract public class Deck {

    protected LinkedList<Card> deck;

    /**
     * Creates and empty deck.
     */
    public Deck() {
        this.deck = new LinkedList<>();
    }

    /**
     * Defines the kind of card that can be added on top of this deck.
     *
     * @param card The card to be added
     * @return boolean
     */
    abstract boolean allowedToAdd(Card card);

    /**
     * Adds a card on top the deck.
     *
     * @param card card to be added
     */
    public void addCard(Card card) {
        this.deck.push(card);
    }

    /**
     * Return the top card without removing it.
     *
     * @return Card
     */
    public Card topCard() {
        return this.deck.peek();
    }

    /**
     * Removes the top card and returns it.
     *
     * @return Card
     */
    public Card takeCard() {
        return this.deck.pop();
    }

    /**
     * Returns the number of card in the deck.
     *
     * @return int
     */
    public int size() {
        return this.deck.size();
    }

    @Override
    public String toString() {
        return this.topCard().toString() + " - size " + this.size();
    }

    /**
     * Return the image of top card in the deck, or transparent image if the is
     * empty.
     *
     * @return top card image or transparent image
     */
    public Image deckImage() {
        if (this.size() == 0) {
            return getImageFromStream("graphics/empty_deck.png");
        }
        return getImageFromStream(this.topCard().getImageSource());
    }

    public Image getImageFromStream(String source) {
        InputStream is = getClass().getClassLoader().
                getResourceAsStream(source);
        BufferedImage bf;
        try {
            bf = ImageIO.read(is);
            Image image = SwingFXUtils.toFXImage(bf, null);
            return image;
        } catch (IOException ex) {
            Logger.getLogger(Deck.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
