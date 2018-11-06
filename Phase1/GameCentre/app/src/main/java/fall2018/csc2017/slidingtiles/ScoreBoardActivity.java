package fall2018.csc2017.slidingtiles;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


/**
 * Display high scores.
 */
public class ScoreBoardActivity extends AppCompatActivity {

    /**
     * The boardManager
     */
    private BoardManager boardManager = null;
    /**
     * The currently logged in users max score.
     */
    //TODO store userMaxScore in the user class instead of here
    private int userMaxScore = 0;
    /**
     * A list of the top 5 scores across all users.
     */
    private int[] maxScores = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
    }

    /**
     * Set the boardManager to the current game.
     * @param boardManager the boardManager.
     */
    public void setBoardManager(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    public void updateScoreOnWin(Context context, int position) {
        if (boardManager.isValidTap(position) && boardManager.puzzleSolved()) {
            if (boardManager.getBoard().getScore() > userMaxScore)
                userMaxScore = boardManager.getBoard().getScore();
        }
    }
}
