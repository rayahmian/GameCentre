package fall2018.csc2017.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

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
        startActivity(tmp);
    }

    /**
     * Switch to the LoginActivity view to login.
     */
    private void switchToLogin() {
        Intent tmp = new Intent(this, LoginActivity.class);
        startActivity(tmp);
    }

    /**
     * Switch to the GuestActivity view to play as a guest.
     */
    private void switchToGuest() {
        Intent tmp = new Intent(this, ChooseGameActivity.class);
        startActivity(tmp);
    }
}
