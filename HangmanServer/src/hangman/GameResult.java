/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package hangman;

/**
 * The status of game.
 * 
 * Can be SOLVED (the word has been ), FAILED or OPEN 
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public enum GameResult {
    OPEN, SOLVED, FAILED
}
