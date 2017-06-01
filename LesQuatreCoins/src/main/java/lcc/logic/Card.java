package lcc.logic;

public class Card {

    private Suit suit;
    private int value;


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
        return valueAsString() + " OF " + getSuit().name();
    }

}
