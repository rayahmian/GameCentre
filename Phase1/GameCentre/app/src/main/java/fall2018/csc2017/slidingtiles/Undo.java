package fall2018.csc2017.slidingtiles;

import android.util.Log;

import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Undo {
    // The Undo functionality that allows the user to undo their last n moves.

    private Board lastBoard = null;

    private BoardManager boardManager;

    private static final String FILENAME = "/data/data/fall2018.csc2017.slidingtiles/files/Undo.ser";

    Undo() {
        get_last_move();
        if (lastBoard != null) {
            boardManager = new BoardManager(lastBoard);
        }
    }

    private void get_last_move() {
        try {
            // Reading obj from file
            FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Deserialize
            this.lastBoard = (Board)ois.readObject();
            fis.close();
            ois.close();
        } catch(FileNotFoundException ex) {
            Log.e("undo activity", "File not found: " + ex.toString());
        } catch (IOException ex){
            Log.e("undo activity", "Cannot read file: " + ex.toString());
        } catch (ClassNotFoundException ex){
            Log.e("undo activity", "File contained unexpected data type: " + ex.toString());
        }
    }
}