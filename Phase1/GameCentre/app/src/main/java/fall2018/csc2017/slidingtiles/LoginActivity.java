package fall2018.csc2017.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    static String username;
    String password;
    public static final String FILENAME = "/data/data/fall2018.csc2017.slidingtiles/files/AccountActivity.ser";
    EditText usernameInput;
    EditText passwordInput;
    Button SignIn;
    Map<String, UserAccount> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addSignInButtonListener();
    }

    /**
     * Activate the ChooseGameActivity button.
     */
    private void addSignInButtonListener() {
        SignIn = findViewById(R.id.SignIn);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameInput = (EditText) findViewById(R.id.usernameText);
                passwordInput = (EditText) findViewById(R.id.passwordText);
                username = usernameInput.getText().toString();
                password = usernameInput.getText().toString();
                UserAccount newUser = new UserAccount(username, password);
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
                if(result.containsKey(username) && result.get(username).checkPassword(password)) {
                    switchToChooseGameActivity();
                }

            }
        }
        );
    }
    private void switchToChooseGameActivity() {
        Intent tmp = new Intent(this, ChooseGameActivity.class);
        startActivity(tmp);
    }
}
