package lcc.highscorelist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class HighScoreList {

    private final String highScorefile = "src/main/resources/highscorelist";

    /**
     * Creates a new list.
     */
    public HighScoreList() {
    }

    /**
     * Checks if the new score is good enough for the list.
     *
     * @param score game score
     * @return boolean
     */
    public boolean checkList(int score) {
        ArrayList<HighScore> list = getListFromFile();
        int listLowest = list.get(list.size() - 1).getScore();
        if (score > listLowest) {
            return true;
        }
        return false;
    }

    /**
     * Adds a new Highscore into list.
     *
     * @param hs new score
     */
    public void add(HighScore hs) {
        ArrayList<HighScore> list = getListFromFile();
        list.add(hs);
        Collections.sort(list);
        if (list.size() > 10) {
            list.remove(10);
        }
        saveFile(list);
    }

    /**
     * Saves the list object into a file.
     *
     * @param list highscore list to be saved
     */
    public void saveFile(ArrayList<HighScore> list) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(this.highScorefile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();

        } catch (IOException ex) {
        }
    }

    /**
     * Loads the high score list from a file.
     *
     * @return returns an empty list, if file not found!
     */
    public ArrayList<HighScore> getListFromFile() {

        FileInputStream fis;
        ObjectInputStream ois;
        ArrayList<HighScore> list = new ArrayList();

        try {
            fis = new FileInputStream(highScorefile);
            ois = new ObjectInputStream(fis);
            list = (ArrayList<HighScore>) ois.readObject();
            fis.close();
            ois.close();

        } catch (IOException | ClassNotFoundException ex) {

        }
        return list;

    }
}
