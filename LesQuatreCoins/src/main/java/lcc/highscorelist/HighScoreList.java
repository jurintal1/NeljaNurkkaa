package lcc.highscorelist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScoreList {

    private ArrayList<HighScore> list;
    private final String highScorefile = "src/main/resources/highscorelist.txt";

    public HighScoreList() {
    }

    public boolean checkList(int score) {
        if (score > this.list.get(this.list.size() - 1).getScore()) {
            return true;
        }
        return false;
    }

    public void add(HighScore hs) {
        this.list.add(hs);
        Collections.sort(this.list);
    }

    public void saveFile() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(this.highScorefile);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.list);
        }
    }

    public ArrayList<HighScore> loadFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(highScorefile);
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.list = (ArrayList<HighScore>) ois.readObject();
        }
        return this.list;
    }

}
