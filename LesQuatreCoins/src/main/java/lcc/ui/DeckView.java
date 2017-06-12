package lcc.ui;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import lcc.logic.Deck;
import lcc.logic.FoundationDeck;
import lcc.logic.Game;

/**
 * This class creates the visual representation for a <Deck> in UI, and provides
 * the methods for drag and drop operations.
 *
 */
public class DeckView extends ImageView {

    public Deck getDeck() {
        return deck;
    }

    private final Deck deck;

    /**
     * Refreshes the deck image to show the current top card.
     */
    public void refreshImage() {
        super.setImage(this.deck.topCard().getImage());
    }

    /**
     * ImageView constructor is used for the visuals and drag and drop
     * operations.
     *
     *
     * @param deck
     */
    public DeckView(Deck deck) {
        super(deck.topCard().getImage());
        this.deck = deck;

        Game game = new Game();

        /**
         * Cards cannot be moved from <FoundationDeck>.
         */
        super.setOnDragDetected((MouseEvent event) -> {
            if (!(deck instanceof FoundationDeck)) {
                Dragboard db = super.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(super.getImage());
                db.setContent(content);
                event.consume();
            }

        });

        super.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != this) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            }
        });

        /**
         * <Game.move> is called to assess if the card can be moved.
         */
        super.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("piip");
                DeckView source = (DeckView) event.getGestureSource();
                Deck sourceDeck = source.getDeck();
                if (game.move(sourceDeck, deck)) {
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
                event.consume();
            }
        });

    }

}
