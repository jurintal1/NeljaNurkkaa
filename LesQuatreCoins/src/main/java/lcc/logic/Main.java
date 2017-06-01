package lcc.logic;

public class Main {

    public static void main(String[] args) {
        CornerDeck cd = new CornerDeck();
        Card aceOfHearts = new Card(1, Suit.HEARTS);
        Card kingOfClubs = new Card(13, Suit.CLUBS);
        cd.addCard(kingOfClubs);
        cd.allowedToAdd(aceOfHearts);

    }
}
