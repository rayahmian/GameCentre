package fall2018.csc2017.slidingtiles;

public class ScoreBoard {
    private BoardManager boardManager;
    private int maxScore = 0;

    public ScoreBoard(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    public void updateMaxScore(int score) {
        if (score > this.maxScore)
            this.maxScore = score;
    }
}
