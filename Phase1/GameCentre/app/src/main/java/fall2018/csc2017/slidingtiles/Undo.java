package fall2018.csc2017.slidingtiles;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Undo implements Observer {
    /** The Undo functionality that allows the user to undo their last n moves.
     * The minimum number of moves a user is allowed to undo is 3.
     * TO DO: try to allow the user to change the number of steps as a bonus
     * TO DO: add the undo button to the interface
     */

    /**
     * An empty list of the most recent moves.
     */
    private ArrayList<Board> moves = new ArrayList<>(3);

    @Override
    public void update(Observable observable, Object o) {
        // TODO: complete
    }

    public Undo(Integer... n) {
        // TODO: complete
        // Change to previous board
        // If n, change to nth previous board
    }
}
