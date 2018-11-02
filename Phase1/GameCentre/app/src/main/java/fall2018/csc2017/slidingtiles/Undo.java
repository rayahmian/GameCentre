package fall2018.csc2017.slidingtiles;

import java.io.Serializable;
import java.io.Externalizable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging;


public class Undo {
    // The Undo functionality that allows the user to undo their last n moves.
    // TO DO: add the undo button to the interface

    private Board lastBoard = null;

    Undo() {
        get_last_move();
        if (lastBoard == null) {
            // no undo is available
            // notify
        }else {
            BoardManager(lastBoard);
        }
    }

    public get_last_move() {
        try {
            // Reading obj from file
            FileInputStream finputStream = new FileInputStream(filename);
            ObjectInputStream oinputStream = new ObjectInputSTream(file);
            // Deserialize
            this.lastBoard = (Board)in.readObject();
            finputStream.close();
            oinputStream.close();
        }
        catch (IOException e){
            logger.error("File not found: " + e.toString())
        }
    }
}

