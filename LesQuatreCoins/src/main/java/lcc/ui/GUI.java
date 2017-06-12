package lcc.ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lcc.logic.Tableau;

/**
 * Graphical user interface for Les Quatre Coins.
 */
public class GUI extends Application {

    @Override
    public void start(Stage window) {

        GridPane grid = new GridPane();

        grid.setHgap(3);
        grid.setVgap(3);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Tableau table = new Tableau();

        
        DeckView ulc = new DeckView(table.getUpLeftCorner());
        ulc.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = ulc.startDragAndDrop(TransferMode.MOVE);            
            ClipboardContent content = new ClipboardContent();
            content.putImage(ulc.getImage());
            event.consume();
        });
        
        grid.add(new DeckView(table.getUpLeftCorner()), 0, 0);
        grid.add(new DeckView(table.getDownLeftCorner()), 0, 3);

        grid.add(new DeckView(table.getLeft1()), 1, 0);
        grid.add(new DeckView(table.getLeft2()), 1, 1);
        grid.add(new DeckView(table.getLeft3()), 1, 2);
        grid.add(new DeckView(table.getLeft4()), 1, 3);

        grid.add(new DeckView(table.getClubsUp()), 2, 0);
        grid.add(new DeckView(table.getDiamondsUp()), 2, 1);
        grid.add(new DeckView(table.getHeartsUp()), 2, 2);
        grid.add(new DeckView(table.getSpadesUp()), 2, 3);

        grid.add(new DeckView(table.getClubsDown()), 3, 0);
        grid.add(new DeckView(table.getDiamondsDown()), 3, 1);
        grid.add(new DeckView(table.getHeartsDown()), 3, 2);
        grid.add(new DeckView(table.getSpadesDown()), 3, 3);

        grid.add(new DeckView(table.getRight1()), 4, 0);
        grid.add(new DeckView(table.getRight2()), 4, 1);
        grid.add(new DeckView(table.getRight3()), 4, 2);
        grid.add(new DeckView(table.getRight4()), 4, 3);

        grid.add(new DeckView(table.getUpRightCorner()), 5, 0);
        grid.add(new DeckView(table.getDownRightCorner()), 5, 3);

        Scene nakyma = new Scene(grid, Color.DARKGREEN);

        window.setScene(nakyma);
        window.show();
    }

    public static void main(String[] args) {

        launch(GUI.class);
    }
}
