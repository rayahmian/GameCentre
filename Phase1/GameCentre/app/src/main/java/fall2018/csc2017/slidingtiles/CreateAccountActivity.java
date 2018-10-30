package fall2018.csc2017.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity {

    String username, password;

    EditText usernameInput;
    EditText passwordInput;
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        addChooseGameActivityButtonListener();
    }

    /**
     * Activate the ChooseGameActivity button.
     */
    private void addChooseGameActivityButtonListener() {
        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameInput = (EditText) findViewById(R.id.usernameText);
                passwordInput = (EditText) findViewById(R.id.passwordText);
                username = usernameInput.getText().toString();
                password = usernameInput.getText().toString();
                UserAccount newUser = new UserAccount(username, password);
                switchToChooseGameActivity();
            }
        });
    }
    private void switchToChooseGameActivity() {
        Intent tmp = new Intent(this, ChooseGameActivity.class);
        startActivity(tmp);
    }
}
