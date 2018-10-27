package fall2018.csc2017.slidingtiles;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Undo implements Observer {

    /**
     * A list of the most recent moves.
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
