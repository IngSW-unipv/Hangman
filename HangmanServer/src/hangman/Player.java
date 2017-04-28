/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package hangman;

/**
 * A generic player.
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
abstract public class Player implements GameObserver {
    /**
     * Method called when the player has to guess a letter.
     * 
     * @param game the game the player is playing
     * @return the letter chosen by the player
     */
    abstract public char chooseLetter(Game game);
}
