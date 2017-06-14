package lcc.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import lcc.logic.Deck;
import lcc.logic.FoundationDeck;
import lcc.logic.Rules;
import lcc.logic.SideDeck;

/**
 * This class creates the visual representation for a <Deck> in UI, and provides
 * the methods for drag and drop operations.
 *
 */
public class DeckView extends ImageView {

    private final Deck deck;
    private final Rules rules;

    /**
     * ImageView constructor is used for the visuals and drag and drop
     * operations.
     *
     *
     * @param deck
     */
    public DeckView(Deck deck, Rules rules, Label score) {
        super.setImage(new Image(deck.topCard().getImageSource()));
        this.deck = deck;
        this.rules = new Rules();

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
         * <Rules.move> is called to assess if the card can be moved.
         */
        super.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                DeckView source = (DeckView) event.getGestureSource();
                Deck sourceDeck = source.getDeck();
                System.out.println(sourceDeck.getClass());
                DeckView target = (DeckView) event.getGestureTarget();
                Deck targetDeck = target.getDeck();
                System.out.println(targetDeck.getClass());

                if (rules.move(sourceDeck, targetDeck)) {
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
                score.setText("" + rules.getScore());
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
        super.setImage(new Image(this.deck.topCard().getImageSource()));
    }

}
