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
import java.util.HashMap;
import java.util.Map;
/**
 * Log into an already existing account.
 */
public class LoginActivity extends AppCompatActivity {
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
     * The Sign In button.
     */
    Button signIn;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        addSignInButtonListener();
    }

    /**
     * Activate the SignInActivity button.
     */
    private void addSignInButtonListener() {
        signIn = findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameInput = (EditText) findViewById(R.id.usernameText);
                passwordInput = (EditText) findViewById(R.id.passwordText);
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();

                if(!(result.containsKey(username) && result.get(username).checkPassword(password))) {
                    String message = "Incorrect username or password";
                    Toast toast = Toast.makeText(getApplicationContext(),
                            message,
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (result.containsKey(username) && result.get(username).checkPassword(password)) {
                    user = result.get(username);
                    String message = "Sign In Successful";
                    Toast toast = Toast.makeText(getApplicationContext(),
                            message,
                            Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                    switchToChooseGameActivity();
                }

            }
        });
    }
    private void switchToChooseGameActivity() {
        Intent tmp = new Intent(this, ChooseGameActivity.class);
        tmp.putExtra(EXTRA_MESSAGE, user);
        startActivity(tmp);
    }
}
