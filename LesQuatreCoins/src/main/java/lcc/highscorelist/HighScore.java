package lcc.highscorelist;

import java.io.Serializable;

/**
 * Creates objects with a name and a score to be used in the high score list.
 *
 * @see HighScoreList
 *
 */
public class HighScore implements Comparable<HighScore>, Serializable {

    String name;
    int score;

    /**
     * Creates a new HighScore object.
     *
     * @param name  player name
     * @param score game score
     */
    public HighScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * HighScore objects are arranged according to score.
     *
     * @param other comparable
     * @return comparison value
     */
    public int compareTo(HighScore other) {
        return other.getScore() - this.getScore(); 
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }

}
