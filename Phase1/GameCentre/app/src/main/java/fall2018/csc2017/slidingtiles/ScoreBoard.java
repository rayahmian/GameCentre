package fall2018.csc2017.slidingtiles;

public class ScoreBoard {
    private int maxScore = 0;

    public ScoreBoard() {

    }

    public void updateMaxScore(int score) {
        if (score > this.maxScore)
            this.maxScore = score;
    }
}
