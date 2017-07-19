package lcc.ui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lcc.highscorelist.HighScore;
import lcc.highscorelist.HighScoreList;
import lcc.logic.Gameplay;
import lcc.logic.Tableau;

/**
 * Graphical user interface for Les Quatre Coins.
 */
public class GUI extends Application {

    private Stage stage;
    private Gameplay gameplay;
    private HighScoreList list;
    private Scene mainView;
    private HighScoreList highScoreList;
    private Tableau table;

    private boolean ended;
    private Label score;

    @Override
    public void start(Stage window) {
        newGame(window);
    }

    /**
     * Starts a new game.
     *
     * @param stage the one and only stage this gui uses
     */
    public void newGame(Stage stage) {
        this.stage = stage;
        this.table = new Tableau();
        this.gameplay = new Gameplay(table);
        this.highScoreList = new HighScoreList();
        this.ended = false;

        stage.setTitle("Les Quatre Coins");
        this.mainView = createMainView();
        stage.setScene(mainView);
        stage.show();

    }

    /**
     * Creates the game view.
     *
     * @return Scene
     */
    public Scene createMainView() {
        BorderPane bPane = new BorderPane();
        VBox rightBox = new VBox();
        rightBox.setPadding(new Insets(100, 100, 100, 100));
        rightBox.setSpacing(30);
        rightBox.setBackground(new Background(new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        this.score = new Label("" + gameplay.getScore());
        score.setTextFill(Color.WHITESMOKE);
        score.setFont(new Font("Arial", 60));

        Button restart = new Button("Aloita alusta");
        restart.setOnAction(e -> {
            this.ended = true;
            if (this.highScoreList.checkList(gameplay.getScore())) {
                addToHighScoreList();
            } else {
                newGame(this.stage);
            }

        });

        Button highscores = new Button("High Score -lista");
        highscores.setOnAction(e -> {
            this.stage.setScene(createListView());

        });

        rightBox.getChildren().addAll(score, restart, highscores);
        bPane.setRight(rightBox);

        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        bPane.setLeft(grid);

        grid.setHgap(3);
        grid.setVgap(3);
        grid.setPadding(new Insets(10, 100, 10, 100));

        grid.add(new DeckView(table.getUpLeftCorner(), gameplay, this), 0, 0);
        grid.add(new DeckView(table.getDownLeftCorner(), gameplay, this), 0, 3);
        grid.add(new DeckView(table.getLeft1(), gameplay, this), 1, 0);
        grid.add(new DeckView(table.getLeft2(), gameplay, this), 1, 1);
        grid.add(new DeckView(table.getLeft3(), gameplay, this), 1, 2);
        grid.add(new DeckView(table.getLeft4(), gameplay, this), 1, 3);

        grid.add(new DeckView(table.getClubsUp(), gameplay, this), 2, 0);
        grid.add(new DeckView(table.getDiamondsUp(), gameplay, this), 2, 1);
        grid.add(new DeckView(table.getHeartsUp(), gameplay, this), 2, 2);
        grid.add(new DeckView(table.getSpadesUp(), gameplay, this), 2, 3);

        grid.add(new DeckView(table.getClubsDown(), gameplay, this), 3, 0);
        grid.add(new DeckView(table.getDiamondsDown(), gameplay, this), 3, 1);
        grid.add(new DeckView(table.getHeartsDown(), gameplay, this), 3, 2);
        grid.add(new DeckView(table.getSpadesDown(), gameplay, this), 3, 3);

        grid.add(new DeckView(table.getRight1(), gameplay, this), 4, 0);
        grid.add(new DeckView(table.getRight2(), gameplay, this), 4, 1);
        grid.add(new DeckView(table.getRight3(), gameplay, this), 4, 2);
        grid.add(new DeckView(table.getRight4(), gameplay, this), 4, 3);

        grid.add(new DeckView(table.getUpRightCorner(), gameplay, this), 5, 0);
        grid.add(new DeckView(table.getDownRightCorner(), gameplay, this), 5, 3);

        return new Scene(bPane, 1200, 680, Color.FORESTGREEN);
    }

    /**
     * Creates the form view for high score list entry.
     *
     * @return Scene
     */
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
        button.setOnAction(e -> {
            this.highScoreList.add(new HighScore(name.getText(), this.gameplay.getScore()));
            System.out.println(this.highScoreList.getListFromFile());
            this.stage.setScene(createListView());
        });

        HBox box = new HBox(10);
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().add(button);
        grid.add(box, 1, 4);

        return new Scene(grid, 1200, 680);

    }

    /**
     * Creates the view for high score list.
     *
     * @return the Scene with a view of high score list
     */
    public Scene createListView() {
        ArrayList<HighScore> list = highScoreList.getListFromFile();
        String listString = "";
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                listString += list.get(i).toString() + "\n";
            }
        }
        Text text = new Text(listString);
        text.setFill(Color.WHITESMOKE);
        text.setFont(new Font("Arial", 40));

        Button back = new Button("Takaisin peliin");
        back.setOnAction(e -> {
            if (this.ended) {
                newGame(this.stage);
            }
            stage.setScene(mainView);

        });

        VBox vb = new VBox(text, back);
        vb.setPadding(new Insets(25, 25, 25, 25));
        vb.setAlignment(Pos.CENTER);
        vb.setBackground(
                new Background(new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        return new Scene(vb, 1200, 680);
    }

    /**
     * Opens the form where the player can give her name for the high score
     * list.
     */
    public void addToHighScoreList() {
        this.stage.setScene(createFormView());

    }

    public Label getScore() {
        return score;
    }

    public void setScore(Label score) {
        this.score = score;
    }

    public void winning() {
        this.ended = true;

        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text text
                = new Text("No niin, se oli siinä. Ihan kiva.");
        text.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
        text.setFill(Color.WHITESMOKE);
        text.setWrappingWidth(200);
        grid.add(text, 0, 0, 2, 1);

        Button button = new Button("Eteenpäin!");
        button.setOnAction(e -> {
            if (this.highScoreList.checkList(gameplay.getScore())) {
                addToHighScoreList();
            } else {
                newGame(this.stage);
            }
        });

        HBox box = new HBox(10);
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().add(button);
        grid.add(box, 1, 4);

        this.stage.setScene(new Scene(grid, 1200, 680, Color.FORESTGREEN));

    }

    /**
     * and this here starts the whole thing.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(GUI.class);
    }
}
