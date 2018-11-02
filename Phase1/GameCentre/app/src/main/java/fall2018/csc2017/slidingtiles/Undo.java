package fall2018.csc2017.slidingtiles;

import java.io.Serializable;
import java.io.Externalizable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Undo {
    /**The Undo functionality that allows the user to undo their last n moves.
     * TO DO: add the undo button to the interface
     */

    private Board lastBoard = null;

    Undo() {
        get_last_move();
        if (lastBoard == null) {
            // no undos are available
            // notify
        }else {
            BoardManager(lastBoard);
        }
    }

    public get_last_move() {
        try {
            // Reading obj from file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputSTream(file);

            // Deserialize
            this.lastBoard = (Board)in.readObject();

            in.close();
            file.close();
        }
        catch (IOException e){
            // no undos are available
        }
    }
}

