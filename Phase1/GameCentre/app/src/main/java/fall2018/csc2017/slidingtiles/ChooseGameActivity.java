package fall2018.csc2017.slidingtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Choose which game you want to play.
 */
public class ChooseGameActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_choose_game);
        Intent intent = getIntent();
        user = (UserAccount) intent.getSerializableExtra(CreateAccountActivity.EXTRA_MESSAGE);
        addSlidingTilesButtonListener();
    }

    /**
     * Activate the SlidingTiles button.
     */
    private void addSlidingTilesButtonListener() {
        Button guestButton = findViewById(R.id.slidingTilesButton);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToSlidingTiles();
            }
        });
    }

    /**
     * Switch to the CreateAccountActivity view to create an account.
     */
    private void switchToSlidingTiles() {
        Intent tmp = new Intent(this, StartingActivity.class);
        tmp.putExtra(EXTRA_MESSAGE, user);
        startActivity(tmp);
    }
}
