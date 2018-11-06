package fall2018.csc2017.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * The initial activity for the sliding puzzle tile app.
 */

public class AccountActivity extends AppCompatActivity {

    /**
     * The main save file with all user information.
     */
    public static final String FILENAME = "/data/data/fall2018.csc2017.slidingtiles/files/AccountActivity.ser";
    /**
     * Used when writing changes to user information save file.
     */
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        try {
            Map<String, UserAccount> users = new HashMap<>();
            // write object to file
            fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        addNewAccountButtonListener();
        addLoginButtonListener();
        addGuestButtonListener();
    }

    /**
     * Activate the Guest button.
     */
    private void addGuestButtonListener() {
        Button guestButton = findViewById(R.id.guestButton);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToGuest();
            }
        });
    }

    /**
     * Activate the login button.
     */
    private void addLoginButtonListener() {
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToLogin();
            }
        });
    }

    /**
     * Activate the New Account button.
     */
    private void addNewAccountButtonListener() {
        Button newAccountButton = findViewById(R.id.newAccountButton);
        newAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToCreateAccount();
            }
        });
    }

    /**
     * Switch to the CreateAccountActivity view to create an account.
     */
    private void switchToCreateAccount() {
        Intent tmp = new Intent(this, CreateAccountActivity.class);
        startActivityForResult(tmp, 0);
    }

    /**
     * Switch to the LoginActivity view to login.
     */
    private void switchToLogin() {
        Intent tmp = new Intent(this, LoginActivity.class);
        startActivityForResult(tmp, 0);
    }

    /**
     * Switch to the GuestActivity view to play as a guest.
     */
    private void switchToGuest() {
        Intent tmp = new Intent(this, ChooseGameActivity.class);
        startActivity(tmp);
    }

    /**
     * Handles the data in the return intent from any latter activities.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            String message = "Logged Out";
            Toast toast = Toast.makeText(getApplicationContext(),
                    message,
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
