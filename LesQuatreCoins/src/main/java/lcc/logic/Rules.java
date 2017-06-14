package lcc.logic;

import lcc.ui.GUI;

/**
 *
 * The Rules class controls the manner in which cards be moved from one pile to
 * another and the creation of score point.
 */
public class Rules {

    private int score;
    final int moveScore = 1;
    final int moveToFoundationScore = 10;
    final int FoundationCompletedScore = 1000;
    final int gameCompletedScore = 100000;

    public Rules() {
        Tableau table = new Tableau();
        GUI gui = new GUI();
        this.score = 0;
    }

    public boolean move(Deck source, Deck target) {
        if (source == target || source instanceof FoundationDeck
                || !target.allowedToAdd(source.topCard())) {
            return false;
        }
        if (target instanceof FoundationDeck) {
            return moveToFoundationDeck(source, (FoundationDeck) target);
        }
        this.score = this.score + moveScore;
        target.addCard(source.takeCard());
        return true;
    }

    public boolean moveToFoundationDeck(Deck source, FoundationDeck target) {
        if (source instanceof SideDeck) {
            if(((SideDeck) source).getSuit() != target.getSuit()) {
                return false;
            }                       
        }
        this.score = this.score + moveToFoundationScore;        
        target.addCard(source.takeCard());
        return true;
    }

    public int getScore() {
        return this.score;
    }
    
    

}
