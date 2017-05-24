package lcc.logic;

public class Card {

    private int suit;
    private int value;

    public final static int CLUBS = 0;
    public final static int DIAMONDS = 1;
    public final static int HEARTS = 2;
    public final static int SPADES = 3;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    public Card(int value, int suit) {
        if (suit < 0 || suit > 3 || value < 1 || value > 13) {
            throw new IllegalArgumentException();
        }        
        this.suit = suit;
        this.value = value;
    }  

    

    

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String suitAsString() {
        switch (this.suit) {
            case 0:
                return "CLUBS";
            case 1:
                return "DIAMONDS";
            case 2:
                return "HEARTS";
            case 3:
                return "SPADES";
            default:
                return "SPADES";
        }
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
        return valueAsString() + " OF " + suitAsString();
    }

}
