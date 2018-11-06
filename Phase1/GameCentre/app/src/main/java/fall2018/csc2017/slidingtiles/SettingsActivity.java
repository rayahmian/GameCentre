package fall2018.csc2017.slidingtiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
/**
 * Allows user to change game complexity.
 */
public class SettingsActivity extends AppCompatActivity {
    /**
     * Unique tag for intent reply.
     */
    public static final String EXTRA_REPLY = "fall2018.csc2017.slidingtiles.extra.reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    /**
     * Called when the user taps a button to change complexity.
     *
     * @param complexity integer representing the complexity of game wanted (i.e. 3 => "3x3")
     */
    public void buttonComplexityPressed(int complexity) {
        String size = Integer.toString(complexity);
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, size);
        setResult(RESULT_OK, replyIntent);

        String message = String.format("Game complexity has been set to %sx%s", size, size);
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Called when the user taps the 3x3 button.
     */
    public void button3x3Pressed(View view) {
        buttonComplexityPressed(3);
    }

    /**
     * Called when the user taps the 4x4 button.
     */
    public void button4x4Pressed(View view) {
        buttonComplexityPressed(4);
    }

    /**
     * Called when the user taps the 5x5 button.
     */
    public void button5x5Pressed(View view) {
        buttonComplexityPressed(5);
    }

}
