package lcc.logic;

/**
 * Class represents a playing card.
 */
import java.net.URL;
import javax.swing.ImageIcon;

public class Card {

    private Suit suit;
    private int value;
    private ImageIcon image;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    public Card(int value, Suit suit) {
        if (value < 1 || value > 13) {
            throw new IllegalArgumentException("illegal card value");
        }
        this.suit = suit;
        this.value = value;

        URL imgURL = getClass().getResource("/graphics/ACESPADES.png");
        if (imgURL == null) {
            this.image = new ImageIcon();
            System.err.println("card image not found");
        } else {
            this.image = new ImageIcon((Card.class.getResource("/graphics/ACESPADES.png")));
        }

    }

    public ImageIcon getImage() {
        return image;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    /**
     * Represent the value of playing card as String.
     * The visible representation changes for Aces, Kings, Queens, and Jacks.
     *
     * @return The card value as String.
     */
    public String valueAsString() {
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return valueAsString() + getSuit().name();
    }

}
