package fall2018.csc2017.slidingtiles;

import android.support.annotation.NonNull;

import java.util.Observable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * The sliding tiles board.
 */
public class Board extends Observable implements Serializable, Iterable<Tile>, Score {

    /**
     * The number of rows.
     */
    private final int NUM_ROWS;

    /**
     * The number of rows.
     */
    private final int NUM_COLS;

    /**
     * The tiles on the board in row-major order.
     */
    private Tile[][] tiles;

    /**
     *  The players score.
     */
    private int score = 50;

    /**
     * A new board of tiles in row-major order.
     * Precondition: len(tiles) == NUM_ROWS * NUM_COLS
     *
     * @param tiles the tiles for the board
     */
    Board(List<Tile> tiles, int rows, int columns) {
        NUM_ROWS = rows;
        NUM_COLS = columns;
        this.tiles = new Tile[NUM_ROWS][NUM_COLS];
        Iterator<Tile> iter = tiles.iterator();

        for (int row = 0; row != NUM_ROWS; row++) {
            for (int col = 0; col != NUM_COLS; col++) {
                this.tiles[row][col] = iter.next();
            }
        }
    }

    /**
     * Return the number of tiles on the board.
     *
     * @return the number of tiles on the board
     */
    int numTiles() {
        return NUM_COLS * NUM_ROWS;
    }

    /**
     * Return the tile at (row, col)
     *
     * @param row the tile row
     * @param col the tile column
     * @return the tile at (row, col)
     */
    Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    /**
     * Swap the tiles at (row1, col1) and (row2, col2)
     *
     * @param row1 the first tile row
     * @param col1 the first tile col
     * @param row2 the second tile row
     * @param col2 the second tile col
     */
    void swapTiles(int row1, int col1, int row2, int col2) {
        Tile temp = getTile(row1, col1);
        tiles[row1][col1] = getTile(row2, col2);
        tiles[row2][col2] = temp;

        if (this.score > 1) {
            this.score--;
        }

        setChanged();
        notifyObservers();
    }

    /**
     * Return the number of rows.
     *
     * @return the number of rows
     */
     int getNUM_ROWS(){return NUM_ROWS;}

    /**
     * Return the number of rows.
     *
     * @return the number of rows
     */
    int getNUM_COLS(){return NUM_COLS;}

    /**
     * Return a string representation of tiles in row-major order
     *
     * @return a string representation of tiles in row-major order
     */
    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }

    /**
     * Returns an iterator over elements of type Tile.
     *
     * @return an Iterator.
     */
    @NonNull
    @Override
    public Iterator<Tile> iterator() {
        return new BoardIterator();
    }

    /**
     * An iterator over a board in row-major order.
     */
    private class BoardIterator implements Iterator<Tile> {
        /**
         * Tracks the value of the next index.
         */
        int nextIndex = 0;

        /**
         * Returns true if the next index is not the equal the number of tiles
         *
         * @return true if iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return nextIndex != numTiles();
        }

        /**
         * Returns the next tile in row-major order
         *
         * @return the next tile in row-major order
         */
        @Override
        public Tile next() {
            Tile result = Board.this.getTile(nextIndex / NUM_ROWS, nextIndex % NUM_COLS);
            nextIndex++;
            return result;
        }
    }
    /**
     * Return the current score.
     *
     * @return the current score.
     */
    @Override
    public int getScore() {
        return this.score;
    }
    /**
     * Set the current score.
     *
     * @param score the updated score.
     */
    @Override
    public void setScore(int score) {
        this.score = score;
    }
}