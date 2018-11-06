package fall2018.csc2017.slidingtiles;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Undo {
    // The Undo functionality that allows the user to undo their last n moves.

    /**
     * The board of the last move. If there were no prior moves, lastBoard is null.
     */
    public Board lastBoard = null;
    public Board currentBoard = null;
    public ArrayList<Board> boards;

    private static final String FILENAME = "/data/data/fall2018.csc2017.slidingtiles/files/Undo.ser";

    Undo() {
        store_last_move();
        if (canUndo()) {
            BoardManager boardManager = new BoardManager(currentBoard);
            Tile[][] lastMove = lastBoard.getArrayTiles();
            boardManager.removeMove();
            boardManager.getBoard().swapTileList(lastMove);
        }
    }

    /**
     * Store the last move that was made.
     */
    private void store_last_move() {
        try {
            // Reading obj from file
            FileInputStream fis = new FileInputStream(FILENAME);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            // Deserialize
            this.boards = (ArrayList<Board>) ois.readObject();
            if (this.boards.size() >= 2) {
                currentBoard = this.boards.get(this.boards.size() - 1);
                lastBoard = this.boards.get(this.boards.size() - 2);
            }
            fis.close();
            bis.close();
            ois.close();

        } catch(FileNotFoundException ex) {
            Log.e("undo activity", "File not found: " + ex.toString());
        } catch (IOException ex){
            Log.e("undo activity", "Cannot read file: " + ex.toString());
        } catch (ClassNotFoundException ex){
            Log.e("undo activity", "File contained unexpected data type: " + ex.toString());
        }
    }

    /**
     * Return if there is a valid undo available.
     * @return boolean
     */
    public boolean canUndo() { return this.boards.size() >= 2; }

}