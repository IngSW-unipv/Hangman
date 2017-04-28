/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package console;

import hangman.ArtificialPlayer;
import hangman.Hangman;
import hangman.Player;

/**
 * Class for the playing without a network.
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class LocalGame {
    
    /**
     * Play the game with the terminal.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        Hangman game = new Hangman();
        Player player = new LocalPlayer();
        // Player player = new ArtificialPlayer();
        game.playGame(player);
    }
}
