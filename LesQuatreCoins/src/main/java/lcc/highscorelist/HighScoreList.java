package lcc.highscorelist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HighScoreList {

    private ArrayList<HighScore> list;
    private final String highScorefile = "src/main/resources/highscorelist.txt";

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
//        getListFromFile();
//        if (score > this.list.get(this.list.size() - 1).getScore()) {
//            return true;
//        }
        return false;
    }

    /**
     * Adds a new Highscore into list.
     *
     * @param hs new score
     */
    public void add(HighScore hs) {
        this.list.add(hs);
        Collections.sort(this.list);
    }

    /**
     * Saves the list object into a file.
     *
     */
    public void saveFile() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(this.highScorefile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighScoreList.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.list);
        } catch (IOException ex) {
            Logger.getLogger(HighScoreList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Loads the high score list from a file.
     *
     * @return ArrayList high score list
     */
    public ArrayList<HighScore> getListFromFile() {

        FileInputStream fis;
        try {
            fis = new FileInputStream(highScorefile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighScoreList.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        try {
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                {
                    try {
                        this.list = (ArrayList<HighScore>) ois.readObject();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(HighScoreList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return this.list;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HighScoreList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
