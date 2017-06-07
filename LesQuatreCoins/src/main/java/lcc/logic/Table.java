package lcc.logic;

public class Table {

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

    public Table() {
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
            downRightCorner, left1, left2, left3, left4, right1, right2, right3,
            right4};
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

    public void setUpLeftCorner(CornerDeck upLeftCorner) {
        this.upLeftCorner = upLeftCorner;
    }

    public CornerDeck getDownLeftCorner() {
        return downLeftCorner;
    }

    public void setDownLeftCorner(CornerDeck downLeftCorner) {
        this.downLeftCorner = downLeftCorner;
    }

    public CornerDeck getUpRightCorner() {
        return upRightCorner;
    }

    public void setUpRightCorner(CornerDeck upRightCorner) {
        this.upRightCorner = upRightCorner;
    }

    public CornerDeck getDownRightCorner() {
        return downRightCorner;
    }

    public void setDownRightCorner(CornerDeck downRightCorner) {
        this.downRightCorner = downRightCorner;
    }

    public SideDeck getLeft1() {
        return left1;
    }

    public void setLeft1(SideDeck left1) {
        this.left1 = left1;
    }

    public SideDeck getLeft2() {
        return left2;
    }

    public void setLeft2(SideDeck left2) {
        this.left2 = left2;
    }

    public SideDeck getLeft3() {
        return left3;
    }

    public void setLeft3(SideDeck left3) {
        this.left3 = left3;
    }

    public SideDeck getLeft4() {
        return left4;
    }

    public void setLeft4(SideDeck left4) {
        this.left4 = left4;
    }

    public SideDeck getRight1() {
        return right1;
    }

    public void setRight1(SideDeck right1) {
        this.right1 = right1;
    }

    public SideDeck getRight2() {
        return right2;
    }

    public void setRight2(SideDeck right2) {
        this.right2 = right2;
    }

    public SideDeck getRight3() {
        return right3;
    }

    public void setRight3(SideDeck right3) {
        this.right3 = right3;
    }

    public SideDeck getRight4() {
        return right4;
    }

    public void setRight4(SideDeck right4) {
        this.right4 = right4;
    }

    public FoundationDeck getClubsUp() {
        return clubsUp;
    }

    public void setClubsUp(FoundationDeck clubsUp) {
        this.clubsUp = clubsUp;
    }

    public FoundationDeck getDiamondsUp() {
        return diamondsUp;
    }

    public void setDiamondsUp(FoundationDeck diamondsUp) {
        this.diamondsUp = diamondsUp;
    }

    public FoundationDeck getHeartsUp() {
        return heartsUp;
    }

    public void setHeartsUp(FoundationDeck heartsUp) {
        this.heartsUp = heartsUp;
    }

    public FoundationDeck getSpadesUp() {
        return spadesUp;
    }

    public void setSpadesUp(FoundationDeck spadesUp) {
        this.spadesUp = spadesUp;
    }

    public FoundationDeck getClubsDown() {
        return clubsDown;
    }

    public void setClubsDown(FoundationDeck clubsDown) {
        this.clubsDown = clubsDown;
    }

    public FoundationDeck getDiamondsDown() {
        return diamondsDown;
    }

    public void setDiamondsDown(FoundationDeck diamondsDown) {
        this.diamondsDown = diamondsDown;
    }

    public FoundationDeck getHeartsDown() {
        return heartsDown;
    }

    public void setHeartsDown(FoundationDeck heartsDown) {
        this.heartsDown = heartsDown;
    }

    public FoundationDeck getSpadesDown() {
        return spadesDown;
    }

    public void setSpadesDown(FoundationDeck spadesDown) {
        this.spadesDown = spadesDown;
    }

}
