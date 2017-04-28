/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package hangman;

/**
 * Object that gets notified as the game progresses.
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public interface GameObserver {
    
    /**
     * Called when a game changes.
     * 
     * @param game the observed game
     */
    public void update(Game game);    
}
