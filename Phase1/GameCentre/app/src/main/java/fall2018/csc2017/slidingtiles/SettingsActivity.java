package fall2018.csc2017.slidingtiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    // Unique tag for the intent reply.
    public static final String EXTRA_REPLY = "fall2018.csc2017.slidingtiles.extra.reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    /**
     * Called when the user taps the 3x3 button.
     */
    public void button3x3Pressed(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, "3");
        setResult(RESULT_OK, replyIntent);

        String message = "Game complexity has been set to 3x3";
        Toast toast = Toast.makeText(this, message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Called when the user taps the 4x4 button.
     */
    public void button4x4Pressed(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, "4");
        setResult(RESULT_OK, replyIntent);

        String message = "Game complexity has been set to 4x4";
        Toast toast = Toast.makeText(this, message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Called when the user taps the 5x5 button.
     */
    public void button5x5Pressed(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, "5");
        setResult(RESULT_OK, replyIntent);

        String message = "Game complexity has been set to 5x5";
        Toast toast = Toast.makeText(this, message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

}
