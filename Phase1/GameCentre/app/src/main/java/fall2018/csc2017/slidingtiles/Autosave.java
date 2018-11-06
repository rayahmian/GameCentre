package fall2018.csc2017.slidingtiles;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.content.ContextWrapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Implements Autosave functionality.
 */
public class Autosave extends Activity {

    /**
     * Keeps track of previous moves.
     */
    private ArrayList<Board> movesList;
    /**
     * Location of the autosave data.
     */
    public static final String FILENAME = "/data/data/fall2018.csc2017.slidingtiles/files/AutoSave.ser";

    Autosave(ArrayList<Board> moves){
        this.movesList = moves;
        autosaveToFile();
    }

    Autosave(){
        this.movesList = new ArrayList<>();
        autosaveToFile();
    }

    public void autosaveToFile(){
        try {
            FileOutputStream outputStream = new FileOutputStream(FILENAME);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(this.movesList);
            objectOutputStream.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    public ArrayList<Board> autoloadFromFile() {
        try {
            FileInputStream var2 = new FileInputStream(FILENAME);
            BufferedInputStream var3 = new BufferedInputStream(var2);
            ObjectInputStream var4 = new ObjectInputStream(var3);
            this.movesList = (ArrayList<Board>) var4.readObject();
            var4.close();
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
        return movesList;
    }
}
