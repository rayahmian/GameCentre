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
    private Board lastBoard = null;

    /**
     * The current board.
     */
    private Board currentBoard = null;

    /**
     * ArrayList of the serialized boards.
     */
    private ArrayList<Board> boards;

    public static final String FILENAME = "/data/data/fall2018.csc2017.slidingtiles/files/AutoSave.ser";

    Undo() {
        store_last_move();
        if(canUndo()){
            Board newBoard = new Board(lastBoard.getArrayTiles(), lastBoard.getNUM_ROWS(), lastBoard.getNUM_COLS());
            BoardManager boardManager = new BoardManager(newBoard);
            boardManager.setMovesList(boards);
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
            FileInputStream var2 = new FileInputStream(FILENAME);
            BufferedInputStream var3 = new BufferedInputStream(var2);
            ObjectInputStream var4 = new ObjectInputStream(var3);
            boards = (ArrayList<Board>) var4.readObject();
            var4.close();
            System.out.println("Loading");
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
        if(canUndo()){
            System.out.println("Can Undo");
            currentBoard = boards.get(boards.size() - 1);
            lastBoard = boards.get(boards.size() - 2);
        }
    }

    /**
     * Return if there is a valid undo available.
     * @return boolean
     */
    public boolean canUndo() {
        return this.boards != null && this.boards.size() >= 2;
    }

}