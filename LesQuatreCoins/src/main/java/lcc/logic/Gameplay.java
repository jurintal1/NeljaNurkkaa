package lcc.logic;

import lcc.ui.GUI;

/**
 *
 * Class controls the manner in which cards be moved from one pile to another,
 * and the accumulation of score points.
 */
public class Gameplay {

    public boolean complete;

    private int score;
    static final int MOVE = 1;
    static final int MOVE_TO_FOUNDATION = 10;
    static final int FOUNDATION_COMPLETE = 1000;
    static final int GAME_COMPLETE = 100000;

    private final Tableau table;

    /**
     * new GamePlay.
     *
     * @param table for checking if the game is complete
     */
    public Gameplay(Tableau table) {
        this.score = 0;
        this.complete = false;
        this.table = table;
    }

    /**
     * Move top card from one deck to the top of another deck.
     *
     * @param source source deck
     * @param target target deck
     * @return true, if the move was made
     */
    public boolean move(Deck source, Deck target) {
        if (source == target || source instanceof FoundationDeck
                || !target.allowedToAdd(source.topCard())) {
            return false;
        }
        if (target instanceof FoundationDeck) {
            return moveToFoundationDeck(source, (FoundationDeck) target);
        }
        this.score = this.score + MOVE;
        target.addCard(source.takeCard());
        return true;
    }

    /**
     * Move a card to a foundation deck.
     *
     * @param source source deck
     * @param target target foundation deck
     * @return true, if the move can be made
     */
    public boolean moveToFoundationDeck(Deck source, FoundationDeck target) {
        if (source instanceof SideDeck) {
            if (((SideDeck) source).getSuit() != target.getSuit()) {
                return false;
            }
        }
        this.score = this.score + MOVE_TO_FOUNDATION;
        Card movingCard = source.takeCard();
        target.addCard(movingCard);
        if (movingCard.getValue() == 1 || movingCard.getValue() == 13) {
            complete();
        }
        return true;
    }

    /**
     * Checks if the game is complete.
     *
     *
     */
    public void complete() {
        for (Deck fd : table.getFoundationDecks()) {
            if (fd.size() < 13) {
                return;
            }
        }
        this.complete = true;

    }

    public boolean isComplete() {
        return complete;
    }

    public int getScore() {
        return this.score;
    }

}
