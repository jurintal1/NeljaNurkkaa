package lcc.logic;

import lcc.ui.GUI;

/**
 *
 * The Game class includes the rules according to which cards can be move from
 * one deck to another.
 */
public class Game {

    public Game() {
        Tableau table = new Tableau();
        GUI gui = new GUI();
    }

    public boolean move(Deck source, Deck destination) {
        if (source == destination || source instanceof FoundationDeck
                || !destination.allowedToAdd(source.topCard())) {
            return false;
        }
        destination.addCard(source.takeCard());
        return true;
    }

    public boolean move(SideDeck source, FoundationDeck destination) {
        if (source.getSuit() == destination.getSuit()
                && destination.allowedToAdd(source.topCard())) {
            destination.addCard(source.takeCard());
            return true;
        }
        return false;
    }

}
