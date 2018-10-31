package fall2018.csc2017.slidingtiles;

import java.io.Serializable;

public class UserAccount implements Serializable {

    private String password;
    private String username;

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
