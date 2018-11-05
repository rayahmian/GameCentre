package fall2018.csc2017.slidingtiles;

import android.util.Log;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Represent a single user and their information.
 */
public class UserAccount implements Serializable {
    /**
     * The user's username.
     */
    private String username;
    /**
     * The user's password.
     */
    private String password;
    /**
     * The users highest score achieved.
     */
    private int maxScore = 0;
    /**
     * The user's last saved game.
     */
    Board savedGame;

    UserAccount(String username, String password){
        this.username = username;
        this.password = password;
    }
    /**
     * Return if the password input matches the user's password.
     *
     *@param input password attempt.
     */
    public boolean checkPassword(String input){
        return this.password.equals(input);
    }
    /**
     * Return the user's username.
     */
    public String getUsername(){
        return this.username;
    }
    /**
     * Get the users max score.
     *
     * @return the max score.
     */
    public int getMaxScore(){
        return this.maxScore;
    }

    /**
     * Set the users max score to score.
     *
     * @param score The new maxScore.
     */
    public void setMaxScore(int score) {
        this.maxScore = score;
    }


}
