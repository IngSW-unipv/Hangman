/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package console;

import hangman.Player;
import hangman.Game;
import java.io.Console;

/**
 * Manage a player playing with the terminal.
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class LocalPlayer extends Player {
    
    Console console;
        
    /**
     * Constructor.
     */
    public LocalPlayer() {
        console = System.console();
    }
    
    @Override
    public void update(Game game) {
        switch(game.getResult()) {
            case FAILED:
                printBanner("Hai perso!  La parola da indovinare era '" +
                            game.getSecretWord() + "'");
                break;
            case SOLVED:
                printBanner("Hai indovinato!   (" + game.getSecretWord() + ")");
                break;
            case OPEN:
                int rem = Game.MAX_FAILED_ATTEMPTS - game.countFailedAttempts();
                System.out.print("\n" + rem + " tentativi rimasti\n");
                System.out.println(this.gameRepresentation(game));
                System.out.println(game.getKnownLetters());
                break;
        }
    }

    private String gameRepresentation(Game game) {
        int a = game.countFailedAttempts();
        
        String s = "   ___________\n  /       |   \n  |       ";
        s += (a == 0 ? "\n" : "O\n");
        s += "  |     " + (a == 0 ? "\n" : (a < 5
                ? "  +\n"
                : (a == 5 ? "--+\n" : "--+--\n")));
        s += "  |       " + (a < 2 ? "\n" : "|\n");
        s += "  |      " + (a < 3 ? "\n" : (a == 3 ? "/\n" : "/ \\\n"));
        s += "  |\n================\n";
        return s;
    }
    
    private void printBanner(String message) {
        System.out.println("");
        for (int i = 0; i < 80; i++)
            System.out.print("*");
        System.out.println("\n***  " + message);
        for (int i = 0; i < 80; i++)
            System.out.print("*");
        System.out.println("\n");
    }

    /**
     * Ask the user to guess a letter.
     * 
     * @param game
     * @return
     */
    @Override
    public char chooseLetter(Game game) {
        for (;;) {
            System.out.print("Inserisci una lettera: ");
            String line = console.readLine().trim();
            if (line.length() == 1 && Character.isLetter(line.charAt(0))) {
                return line.charAt(0);
            } else {
                System.out.println("Lettera non valida.");
            }
        }
    }
}
