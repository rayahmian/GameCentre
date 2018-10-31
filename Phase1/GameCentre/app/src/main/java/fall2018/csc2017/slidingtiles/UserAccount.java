package fall2018.csc2017.slidingtiles;

import android.util.Log;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserAccount implements Serializable {

    private String username, password;

    Board autoSavedGame, savedGame;

    UserAccount(String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean checkPassword(String input){
        return this.password.equals(input);
    }

    public String getUserName(){
        return this.username;
    }


}
