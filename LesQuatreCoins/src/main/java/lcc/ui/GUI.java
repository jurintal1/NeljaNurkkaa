package lcc.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import lcc.logic.Deck;
import lcc.logic.Table;

/**
 * Graphical user interface for Les Quatre Coins.
 */
public class GUI extends Application {

    private Table table;

    public GUI(Table table) {
        this.table = table;
    }

    @Override
    public void start(Stage ikkuna) {
        Button test = new Button("Tämä on nappi");

        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        grid.add(new ImageView(), 0, 3);
        grid.add(new ImageView(), 0, 3);

        grid.add(new ImageView(), 1, 0);
        grid.add(new ImageView(), 1, 1);
        grid.add(new ImageView(), 1, 2);
        grid.add(new ImageView(), 1, 3);

        grid.add(new ImageView(), 2, 0);
        grid.add(new ImageView(), 2, 1);
        grid.add(new ImageView(), 2, 3);
        grid.add(new ImageView(), 2, 3);

        grid.add(new ImageView(), 3, 0);
        grid.add(new ImageView(), 3, 1);
        grid.add(new ImageView(), 3, 2);
        grid.add(new ImageView(), 3, 3);

        grid.add(new ImageView(), 4, 0);
        grid.add(new ImageView(), 4, 1);
        grid.add(new ImageView(), 4, 2);
        grid.add(new ImageView(), 4, 3);

        grid.add(new ImageView(), 5, 0);
        grid.add(new ImageView(), 5, 3);

        Scene nakyma = new Scene(grid);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

//    public static void refreshDeckImage(GridPane grid, int col, int row, Deck deck) {
//       ImageIcon image = deck.topCard().getImage();
//       grid.add(image, col, row);
//        
//    }
//
//    public static void main(String[] args) {
//        launch(GUI.class);
//    }
}
