package fall2018.csc2017.slidingtiles;

import android.util.Log;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserAccount implements Serializable {

    private String username, password;

    /**
     * The users highest score achieved
     */
    private int maxScore = 0;
    public BoardManager savedGame;

    UserAccount(String username, String password){
        this.username = username;
        this.password = password;
        this.savedGame = null;
    }

    public boolean checkPassword(String input){
        return this.password.equals(input);
    }

    public String getUsername(){
        return this.username;
    }

    /**
     * Get the users max score
     * @return the max score.
     */
    public int getMaxScore(){
        return this.maxScore;
    }

    /**
     * Set the users max score to score
     * @param score The new maxScore.
     */
    public void setMaxScore(int score) {
        this.maxScore = score;
    }

}
