package lcc.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import lcc.logic.Deck;
import lcc.logic.FoundationDeck;
import lcc.logic.Gameplay;

/**
 * This class creates the visual representation for a deck in UI, and provides
 * the methods for drag and drop operations.
 *
 */
public class DeckView extends ImageView {

    private final Deck deck;
    private final Gameplay gameplay;
    private final GUI gui;

    /**
     * ImageView constructor is used for the visuals and drag and drop
     * operations.
     *
     * @param deck the deck shown here
     * @param gameplay for checking the legality of moves
     * @param score for displaying the score in UI after a move
     */
    public DeckView(Deck deck, Gameplay gameplay, GUI gui) {
        super.setImage(deck.deckImage());
        this.deck = deck;
        this.gameplay = gameplay;
        this.gui = gui;

        /**
         * Cards cannot be moved from a foundation deck or empty deck.
         */
        super.setOnDragDetected((MouseEvent event) -> {
            if (!(deck instanceof FoundationDeck) && !(deck.size() == 0)) {
                Dragboard db = super.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(super.getImage());
                db.setContent(content);
                event.consume();
            }

        });

        super.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != this) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            }
        });

        /**
         * gameplay is called to assess if the card can be moved. *
         *
         */
        super.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                DeckView source = (DeckView) event.getGestureSource();
                Deck sourceDeck = source.getDeck();
                DeckView target = (DeckView) event.getGestureTarget();
                Deck targetDeck = target.getDeck();
                if (gameplay.move(sourceDeck, targetDeck)) {
                    refreshImage();
                    event.setDropCompleted(true);
                }
                event.consume();
            }
        });

        /**
         * After a card is moved, the source deck image is updated.
         */
        super.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                refreshImage();
                gui.getScore().setText("" + gameplay.getScore());
                if (gameplay.isComplete()) {
                    // gui.winning();
                }
                event.consume();
            }
        });

    }

    public Deck getDeck() {
        return deck;

    }

    /**
     * Refreshes the deck image to show the current top card.
     */
    public void refreshImage() {
        super.setImage(this.deck.deckImage());
    }

}
