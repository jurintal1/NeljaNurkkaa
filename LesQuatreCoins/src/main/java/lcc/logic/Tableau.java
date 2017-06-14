package lcc.logic;

/**
 * The class represents all the decks in a game of Les Quatre Coins.
 */
public class Tableau {

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

    private Deck[] manoeuvreDecks;

    public Tableau() {
        createFoundationDecks();
        addAcesAndKingsToFoundationDecks();
        createManoeuvreDecks();
        dealToManoeuvreDecks();
    }

    public final void createManoeuvreDecks() {
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
        Deck[] decks = {upLeftCorner, downLeftCorner, upRightCorner,
            downRightCorner, left1, left2, left3, left4, right1, right2,
            right3, right4};
        this.manoeuvreDecks = decks;
    }

    public Deck[] getManoeuvreDecks() {
        return manoeuvreDecks;
    }

    public final void createFoundationDecks() {
        this.clubsDown = new FoundationDeck(Suit.CLUBS, Direction.DOWN);
        this.clubsUp = new FoundationDeck(Suit.CLUBS, Direction.UP);
        this.diamondsDown = new FoundationDeck(Suit.DIAMONDS, Direction.DOWN);
        this.diamondsUp = new FoundationDeck(Suit.DIAMONDS, Direction.UP);
        this.heartsDown = new FoundationDeck(Suit.HEARTS, Direction.DOWN);
        this.heartsUp = new FoundationDeck(Suit.HEARTS, Direction.UP);
        this.spadesDown = new FoundationDeck(Suit.SPADES, Direction.DOWN);
        this.spadesUp = new FoundationDeck(Suit.SPADES, Direction.UP);

    }

    public final void addAcesAndKingsToFoundationDecks() {
        clubsDown.addCard(new Card(Card.KING, Suit.CLUBS));
        clubsUp.addCard(new Card(Card.ACE, Suit.CLUBS));
        diamondsDown.addCard(new Card(Card.KING, Suit.DIAMONDS));
        diamondsUp.addCard(new Card(Card.ACE, Suit.DIAMONDS));
        heartsDown.addCard(new Card(Card.KING, Suit.HEARTS));
        heartsUp.addCard(new Card(Card.ACE, Suit.HEARTS));
        spadesDown.addCard(new Card(Card.KING, Suit.SPADES));
        spadesUp.addCard(new Card(Card.ACE, Suit.SPADES));
    }

    public final void dealToManoeuvreDecks() {
        Dealer dealer = new Dealer();
        dealer.deal(this.manoeuvreDecks);

    }

    public CornerDeck getUpLeftCorner() {
        return upLeftCorner;
    }

    public CornerDeck getDownLeftCorner() {
        return downLeftCorner;
    }

    public CornerDeck getUpRightCorner() {
        return upRightCorner;
    }

    public CornerDeck getDownRightCorner() {
        return downRightCorner;
    }

    public SideDeck getLeft1() {
        return left1;
    }

    public SideDeck getLeft2() {
        return left2;
    }

    public SideDeck getLeft3() {
        return left3;
    }

    public SideDeck getLeft4() {
        return left4;
    }

    public SideDeck getRight1() {
        return right1;
    }

    public SideDeck getRight2() {
        return right2;
    }

    public SideDeck getRight3() {
        return right3;
    }

    public SideDeck getRight4() {
        return right4;
    }

    public FoundationDeck getClubsUp() {
        return clubsUp;
    }

    public FoundationDeck getDiamondsUp() {
        return diamondsUp;
    }

    public FoundationDeck getHeartsUp() {
        return heartsUp;
    }

    public FoundationDeck getSpadesUp() {
        return spadesUp;
    }

    public FoundationDeck getClubsDown() {
        return clubsDown;
    }

    public FoundationDeck getDiamondsDown() {
        return diamondsDown;
    }

    public FoundationDeck getHeartsDown() {
        return heartsDown;
    }

    public FoundationDeck getSpadesDown() {
        return spadesDown;
    }

}