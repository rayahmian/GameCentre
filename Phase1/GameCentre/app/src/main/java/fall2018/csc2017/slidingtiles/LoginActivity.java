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
public class LoginActivity extends AccountManagementActivity {
    /**
     * The Sign In button.
     */
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

}
