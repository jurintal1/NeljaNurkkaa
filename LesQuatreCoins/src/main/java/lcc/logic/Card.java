package lcc.logic;

import java.io.Serializable;
import javafx.scene.image.Image;

/**
 * Class Card represents a playing card.
 */
public class Card {

    private final Suit suit;
    private final int value;
    private String imagesource;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    /**
     * Creates a card with the defined value and constructs a path to the
     * corresponding image file.
     *
     * @param value card face value
     * @param suit card suit
     */
    public Card(int value, Suit suit) {
        if (value < 1 || value > 13) {
            throw new IllegalArgumentException("illegal card value");
        }
        this.suit = suit;
        this.value = value;
        this.imagesource = "File:src/main/resources/graphics/" + this.valueAsString() + this.suit + ".png";

    }

    public String getImageSource() {
        return imagesource;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    /**
     * Represent the value of playing card as String. The visible representation
     * changes for Aces, Kings, Queens, and Jacks.
     *
     * @return The card value as String.
     */
    public final String valueAsString() {
        switch (this.value) {
            case 1:
                return "ACE";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "JACK";
            case 12:
                return "QUEEN";
            case 13:
                return "KING";
            default:
                return "ACE";
        }
    }

    @Override
    public String toString() {
        return valueAsString() + getSuit().name();
    }

}
