package fall2018.csc2017.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Parent class for account management activities.
 */
public abstract class AccountManagementActivity extends AppCompatActivity{
    /**
     * The entered username.
     */
    String username;
    /**
     * The entered password.
     */
    String password;
    /**
     * The main save file with all user information.
     */
    public static final String FILENAME = "/data/data/fall2018.csc2017.slidingtiles/files/AccountActivity.ser";
    /**
     * The username text field.
     */
    EditText usernameInput;
    /**
     * The password text field.
     */
    EditText passwordInput;

    /**
     * Key-values pairs of usernames and their associated UserAccount objects
     */
    Map<String, UserAccount> result;
    /**
     * The current logged in user.
     */
    UserAccount user;
    /**
     * Unique tag required for the intent extra.
     */
    public static final String EXTRA_MESSAGE = "fall2018.csc2017.slidingtiles.extra.message";
    /**
     * Unique tag for intent reply.
     */
    public static final String EXTRA_REPLY = "fall2018.csc2017.slidingtiles.extra.reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            // read object from file
            FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (Map<String, UserAccount>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switch to the choose game activity.
     */
    void switchToChooseGameActivity() {
        Intent tmp = new Intent(this, ChooseGameActivity.class);
        tmp.putExtra(EXTRA_MESSAGE, user);
        startActivity(tmp);
    }
}
