
package lcc.lesquatrecoins;

public class Main {
    
    public static void main (String[] args) {
        
        Card secondCard = new Card(Card.QUEEN, Card.DIAMONDS);
        Card thirdCard = new Card(11, Card.CLUBS);
        System.out.println(secondCard);
        System.out.println(thirdCard);
        FoundationDeck fd = new FoundationDeck(1, "up");
        fd.addCard(thirdCard);
        System.out.println(fd.topCard());
        Card c = new Card(Card.JACK, Card.HEARTS);
        System.out.println(c);
        
    
}
}



