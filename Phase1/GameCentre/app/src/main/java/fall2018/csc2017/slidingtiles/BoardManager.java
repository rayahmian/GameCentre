package fall2018.csc2017.slidingtiles;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Manage a board, including swapping tiles, checking for a win, and managing taps.
 */
class
BoardManager extends AppCompatActivity implements Serializable, Score {

    /**
     * The board being managed.
     */
    private Board board;

    /**
     *  The players score.
     */
    private int score = 50;

    /**
     * Manage a board that has been pre-populated.
     *
     * @param board the board
     */
    BoardManager(Board board) {
        this.board = board;
    }

    /**
     * Return the current board.
     */
    Board getBoard() {
        return board;
    }

    /**
     * Manage a new shuffled board.
     */
    BoardManager(int rows, int cols) {
        List<Tile> tiles = new ArrayList<>();
        final int numTiles = rows * cols;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            tiles.add(new Tile(tileNum, rows));
        }

        Collections.shuffle(tiles);
        this.board = new Board(tiles, rows, cols);
    }

    /**
     * Return whether the tiles are in row-major order.
     *
     * @return whether the tiles are in row-major order
     */
    boolean puzzleSolved() {
        boolean solved = true;
        int correct = 1;
        for (Tile curr : getBoard()) {
            if (curr.getId() != correct)
                solved = false;
            correct++;
        }
        return solved;
    }

    /**
     * Return whether any of the four surrounding tiles is the blank tile.
     *
     * @param position the tile to check
     * @return whether the tile at position is surrounded by a blank tile
     */
    boolean isValidTap(int position) {

        int row = position / board.getNUM_ROWS();
        int col = position % board.getNUM_COLS();
        int blankId = board.numTiles();
        // Are any of the 4 the blank tile?
        Tile above = row == 0 ? null : board.getTile(row - 1, col);
        Tile below = row == board.getNUM_ROWS() - 1 ? null : board.getTile(row + 1, col);
        Tile left = col == 0 ? null : board.getTile(row, col - 1);
        Tile right = col == board.getNUM_COLS() - 1 ? null : board.getTile(row, col + 1);
        return (below != null && below.getId() == blankId)
                || (above != null && above.getId() == blankId)
                || (left != null && left.getId() == blankId)
                || (right != null && right.getId() == blankId);
    }

    /**
     * Process a touch at position in the board, swapping tiles as appropriate.
     *
     * @param position the position
     */
    void touchMove(int position) {

        int row = position / board.getNUM_ROWS();
        int col = position % board.getNUM_COLS();
        int blankId = board.numTiles();

        if (isValidTap(position)) {
            int above = (row == 0) ? -1 : board.getTile(row - 1, col).getId();
            int below = (row == (board.getNUM_ROWS() - 1)) ? -1 : board.getTile(row + 1, col).getId();
            int left = (col == 0) ? -1 : board.getTile(row, col - 1).getId();
            int right = (col == (board.getNUM_COLS() - 1)) ? -1 : board.getTile(row, col + 1).getId();
            int[] iter = {above, below, left, right};
            for (int i = 0; i < 4; i++)
                if (iter[i] == blankId) {
                    int new_row = (i < 2) ? (row - 1) + (2 * i) : row;
                    int new_col = (i >= 2) ? (col - 1) + (2 * (i % 2)) : col;
                    board.swapTiles(row, col, new_row, new_col);
                }
            if (this.score > 1) {
                this.score--;
            }


        }

    }

    @Override
    public int getScore() {
        return this.score - 1;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }
}