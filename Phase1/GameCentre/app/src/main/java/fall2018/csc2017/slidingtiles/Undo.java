package fall2018.csc2017.slidingtiles;

import java.io.Serializable;
import java.io.Externalizable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Undo {
    /** The Undo functionality that allows the user to undo their last n moves.
     * The minimum number of moves a user is allowed to undo is 3.
     * TO DO: try to allow the user to change the number of steps as a bonus
     * TO DO: add the undo button to the interface
     */

    private Board lastBoard = null;

    Undo() {
        // @TODO
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
            Log.e("Exception", "No previous moves available: " + e.toString());
        }
    }
}


class Test {
    /** Test to deserialize boards. */
}