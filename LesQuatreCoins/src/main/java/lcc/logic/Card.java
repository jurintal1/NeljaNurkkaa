package lcc.logic;

import javafx.scene.image.Image;

public class Card  {

    private Suit suit;
    private int value;
    private Image image;


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
        this.image = new Image("src/main/resources/graphics" + this.toString() + ".png");
    }

    public Image getImage() {
        return image;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    

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
            default:
                return "ACE";
        }
    }

    @Override
    public String toString() {
        return valueAsString() + getSuit().name();
    }

}
