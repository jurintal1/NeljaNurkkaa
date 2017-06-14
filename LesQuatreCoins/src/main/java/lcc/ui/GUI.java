package lcc.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lcc.highscorelist.HighScore;
import lcc.highscorelist.HighScoreList;
import lcc.logic.Rules;
import lcc.logic.Tableau;

/**
 * Graphical user interface for Les Quatre Coins.
 */
public class GUI extends Application {

    private Stage window;
    private Rules rules;
    private HighScoreList list;
    private Scene mainView;
    private Scene FormView;
    private HighScoreList highScoreList;

    @Override
    public void start(Stage window) {
        this.window = window;
        newGame();
    }

    public void newGame() {
        this.rules = new Rules();
        this.list = new HighScoreList();
        this.highScoreList = new HighScoreList();

        window.setTitle("Les Quatre Coins");
        this.mainView = createMainView();
        this.FormView = createFormView();
        window.setScene(mainView);
        window.show();

    }

    public Scene createMainView() {
        BorderPane bPane = new BorderPane();

        VBox rightBox = new VBox();
        rightBox.setPadding(new Insets(100, 100, 100, 100));
        rightBox.setSpacing(30);
        rightBox.setBackground(new Background(new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        Label score = new Label("" + rules.getScore());
        score.setTextFill(Color.WHITESMOKE);
        score.setFont(new Font("Arial", 60));

        Button restart = new Button("Aloita alusta");
        restart.setOnAction(e -> {
            if (list.checkList(rules.getScore())) {
                window.setScene(mainView);
            }
            newGame();
        });

        Button highscores = new Button("High Score -lista");
        highscores.setOnAction(e -> {
            try {           
                window.setScene(createListView());
            } catch (IOException ex) {
                System.out.println("ei onnistu");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        
        
        rightBox.getChildren().addAll(score, restart, highscores);
        bPane.setRight(rightBox);

        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        bPane.setLeft(grid);

        grid.setHgap(3);
        grid.setVgap(3);
        grid.setPadding(new Insets(10, 100, 10, 100));

        Tableau table = new Tableau();

        grid.add(new DeckView(table.getUpLeftCorner(), rules, score), 0, 0);
        grid.add(new DeckView(table.getDownLeftCorner(), rules, score), 0, 3);

        grid.add(new DeckView(table.getLeft1(), rules, score), 1, 0);
        grid.add(new DeckView(table.getLeft2(), rules, score), 1, 1);
        grid.add(new DeckView(table.getLeft3(), rules, score), 1, 2);
        grid.add(new DeckView(table.getLeft4(), rules, score), 1, 3);

        grid.add(new DeckView(table.getClubsUp(), rules, score), 2, 0);
        grid.add(new DeckView(table.getDiamondsUp(), rules, score), 2, 1);
        grid.add(new DeckView(table.getHeartsUp(), rules, score), 2, 2);
        grid.add(new DeckView(table.getSpadesUp(), rules, score), 2, 3);

        grid.add(new DeckView(table.getClubsDown(), rules, score), 3, 0);
        grid.add(new DeckView(table.getDiamondsDown(), rules, score), 3, 1);
        grid.add(new DeckView(table.getHeartsDown(), rules, score), 3, 2);
        grid.add(new DeckView(table.getSpadesDown(), rules, score), 3, 3);

        grid.add(new DeckView(table.getRight1(), rules, score), 4, 0);
        grid.add(new DeckView(table.getRight2(), rules, score), 4, 1);
        grid.add(new DeckView(table.getRight3(), rules, score), 4, 2);
        grid.add(new DeckView(table.getRight4(), rules, score), 4, 3);

        grid.add(new DeckView(table.getUpRightCorner(), rules, score), 5, 0);
        grid.add(new DeckView(table.getDownRightCorner(), rules, score), 5, 3);

        return new Scene(bPane, Color.FORESTGREEN);
    }

    public Scene createFormView() {
        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text text
                = new Text("Fantastista, olet päässyt parhaiden pasianssinpelaajien"
                        + "listalle. Kerro heti nimesi!");
        text.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
        text.setFill(Color.WHITESMOKE);
        text.setWrappingWidth(200);
        grid.add(text, 0, 0, 2, 1);

        TextField name = new TextField();
        name.setMaxWidth(150);
        grid.add(name, 1, 1);

        Button button = new Button("Kyllä!");
        HBox box = new HBox(10);
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().add(button);
        grid.add(box, 1, 4);

        button.setOnAction(e -> {

        });

        return new Scene(grid);

    }

    public Scene createListView() throws IOException, FileNotFoundException, ClassNotFoundException {       

        TextArea text = new TextArea();
        ArrayList<HighScore> scores = highScoreList.loadFile();
        for (int i = 0; i < 10; i++) {
            text.appendText(scores.get(i).toString() + "\n");
        }
        BorderPane bp = new BorderPane(text);
        return new Scene(bp);
    }
    
    

    public static void main(String[] args) {
        launch(GUI.class);
    }
}
