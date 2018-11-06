package fall2018.csc2017.slidingtiles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;


/**
 * Display high scores.
 */
public class ScoreBoardActivity extends AppCompatActivity {

    /**
     * The boardManager
     */
    private BoardManager boardManager = null;
    /**
     * The file containing all registered users.
     */
    public static final String FILENAME = "/data/data/fall2018.csc2017.slidingtiles/files/AccountActivity.ser";
    /**
     * List of all UserAccounts.
     */
    Map<String, UserAccount> result;
    /**
     * The currently logged in users max score.
     */
    //TODO store userMaxScore in the user class instead of here
    private int userMaxScore = 0;
    /**
     * A list of the top 5 scores across all users.
     */
    private int[] maxScores = new int[5];
    /**
     * A list of corresponding usernames.
     */
    private String[] maxUsers = new String[5];
    /**
     * The currently logged in user.
     */
    private UserAccount currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        Intent intent = getIntent();
        currentUser = (UserAccount) intent.getSerializableExtra("currentUser");

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

        currentUser = result.get(currentUser.getUsername());
        userMaxScore = currentUser.getMaxScore();
        getMaxScores(result);
        setScoreboardTable();

        TextView personalBest = (TextView) findViewById(R.id.personalBest);
        personalBest.setText("Personal Best: " + userMaxScore);
    }

    public void getMaxScores(Map<String, UserAccount> userAccounts) {
        for (Map.Entry<String, UserAccount> x: userAccounts.entrySet()
                ) {
            String name = x.getValue().getUsername();
            int score = x.getValue().getMaxScore();
            boolean scoreHigher = false;
            int i = 0;

            while (i < 5 && !scoreHigher) {
                if (maxUsers[i] == null | score > maxScores[i]) {
                    for (int j = 3; j >= i; j--) {
                        maxUsers[j+1] = maxUsers[j];
                        maxScores[j+1] = maxScores[j];
                    }
                    maxScores[i] = score;
                    maxUsers[i] = name;
                    scoreHigher = true;
                }
                i++;
            }
        }
    }

    public void setScoreboardTable() {
        TableLayout scoreboardTable = (TableLayout) findViewById(R.id.scoreboardTable);

        for(int i = 0, j = scoreboardTable.getChildCount(); i < j; i++) {
            TableRow row = (TableRow) scoreboardTable.getChildAt(i);
            TextView username = (TextView) row.getChildAt(0);
            TextView score = (TextView) row.getChildAt(1);

            username.setText(maxUsers[i]);
            score.setText(String.valueOf(maxScores[i]));
        }
    }
}
