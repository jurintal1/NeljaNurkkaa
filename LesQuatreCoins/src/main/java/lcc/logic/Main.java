package lcc.logic;

public class Main {

    public static void main(String[] args) {

        FoundationDeck fd = new FoundationDeck(0, "down");
        Card c = new Card(2, Card.SPADES);
        Card c2 = new Card(Card.ACE, Card.SPADES);
        fd.addCard(c);
        boolean x = fd.allowedToAdd(c2);
        System.out.println(x);

    }
}
