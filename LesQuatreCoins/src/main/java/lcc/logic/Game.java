package lcc.logic;

public class Game {

    private CornerDeck upLeftCorner;
    private CornerDeck downLeftCorner;
    private CornerDeck upRightCorner;
    private CornerDeck downRightCorner;

    private SideDeck left1;
    private SideDeck left2;
    private SideDeck left3;
    private SideDeck left4;
    private SideDeck right1;
    private SideDeck right2;
    private SideDeck right3;
    private SideDeck right4;

    private FoundationDeck clubsUp;
    private FoundationDeck diamondsUp;
    private FoundationDeck heartsUp;
    private FoundationDeck spadesUp;
    private FoundationDeck clubsDown;
    private FoundationDeck diamondsDown;
    private FoundationDeck heartsDown;
    private FoundationDeck spadesDown;

    public Game() {
        createFoundationDecks();
        addAcesAndKingsToFoundationDecks();
        createManoeuvreDecks();
        dealToManoeuvreDecks();
    }

    public void createManoeuvreDecks() {
        this.upLeftCorner = new CornerDeck();
        this.downLeftCorner = new CornerDeck();
        this.upRightCorner = new CornerDeck();
        this.downRightCorner = new CornerDeck();
        this.left1 = new SideDeck(Suit.CLUBS);
        this.left2 = new SideDeck(Suit.DIAMONDS);
        this.left3 = new SideDeck(Suit.HEARTS);
        this.left4 = new SideDeck(Suit.SPADES);
        this.right1 = new SideDeck(Suit.CLUBS);
        this.right2 = new SideDeck(Suit.DIAMONDS);
        this.right3 = new SideDeck(Suit.HEARTS);
        this.right4 = new SideDeck(Suit.SPADES);
    }

    public void createFoundationDecks() {
        this.clubsDown = new FoundationDeck(Suit.CLUBS, Direction.DOWN);
        this.clubsUp = new FoundationDeck(Suit.CLUBS, Direction.UP);
        this.diamondsDown = new FoundationDeck(Suit.DIAMONDS, Direction.DOWN);
        this.diamondsUp = new FoundationDeck(Suit.DIAMONDS, Direction.UP);
        this.heartsDown = new FoundationDeck(Suit.HEARTS, Direction.DOWN);
        this.heartsUp = new FoundationDeck(Suit.HEARTS, Direction.UP);
        this.spadesDown = new FoundationDeck(Suit.SPADES, Direction.DOWN);
        this.spadesUp = new FoundationDeck(Suit.SPADES, Direction.UP);

    }

    public void addAcesAndKingsToFoundationDecks() {
        clubsDown.addCard(new Card(Card.KING, Suit.CLUBS));
        clubsUp.addCard(new Card(Card.ACE, Suit.CLUBS));
        diamondsDown.addCard(new Card(Card.KING, Suit.DIAMONDS));
        diamondsUp.addCard(new Card(Card.ACE, Suit.DIAMONDS));
        heartsDown.addCard(new Card(Card.KING, Suit.HEARTS));
        heartsUp.addCard(new Card(Card.ACE, Suit.HEARTS));
        spadesDown.addCard(new Card(Card.KING, Suit.SPADES));
        spadesUp.addCard(new Card(Card.ACE, Suit.SPADES));
    }

    public void dealToManoeuvreDecks() {
        Dealer dealer = new Dealer();
        Deck[] manoeuvreDecks = {upLeftCorner, downLeftCorner, upRightCorner,
            downRightCorner, left1, left2, left3, left4, right1, right2, right3,
            right4};
        dealer.deal(manoeuvreDecks);

    }

}
