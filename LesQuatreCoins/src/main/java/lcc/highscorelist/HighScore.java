
package lcc.highscorelist;

import java.io.Serializable;

public class HighScore implements Comparable<HighScore>, Serializable {
    String name;
    int score;

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
    
    public int compareTo(HighScore other) {
        return this.getScore() - other.getScore();
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
    
    
    
    
    
}
