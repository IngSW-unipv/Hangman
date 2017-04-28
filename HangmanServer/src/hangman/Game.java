/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package hangman;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a round of the game, where a single word has to be determined by
 * guessing its letters.
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class Game {
    
    public static final int MAX_FAILED_ATTEMPTS = 7;
    
    String secret;
    List<Character> attempts;
    List<GameObserver> observers;
   
    /**
     * Create a new game.
     * 
     * @param word the word to be guessed.
     */
    public Game(String word) {
        this.secret = word.toUpperCase();
        attempts = new ArrayList<>();
        observers = new ArrayList<>();
    }
    
    /**
     * Add a new observer to the game.
     *
     * @param obs the new observer
     */
    public void addObserver(GameObserver obs) {
        observers.add(obs);
    }
    
    /**
     * Notify a change to all the observers.
     */
    public void notifyObservers() {
        for (GameObserver obs : observers)
            obs.update(this);
    }
    
    /**
     * Guess a letter.
     * 
     * @param c the letter guessed by the player
     */
    public void makeAttempt(char c) {
        c = Character.toUpperCase(c);
        if (!attempts.contains(c))
            attempts.add(c);
        this.notifyObservers();
    }
    
    /**
     * @return the word to be guessed
     */
    public String getSecretWord() {
        return secret;
    }
    
    /**
     * A textual representation of the word to be guessed.
     * 
     * Unknown characters are replaced by underscores.
     * 
     * @return the word with some letters replaced by undercores
     */
    public String getKnownLetters() {
        int n = secret.length();
        char [] ls = new char[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1 || attempts.contains(secret.charAt(i)))
                ls[i] = secret.charAt(i);
            else
                ls[i] = '_';
        }
        return new String(ls);
    }
    
    /**
     * Return the number of failed attempts (letters not in the word).
     * 
     * @return the number of failed attempts.
     */
    public int countFailedAttempts() {
        int count = 0;
        for (char a : attempts)
            if (secret.indexOf(a) < 0)
                count++;
        return count;
    }
    
    /**
     * Compute the number of letters that still need to be guessed.
     * 
     * @return the number of missing letters
     */
    public int countMissingLetters() {
        int count = 0;
        for (int i = 1; i < secret.length() - 1; i++)
            if (!attempts.contains(secret.charAt(i)))
                count++;
        return count;
    }
    
    /**
     * Return the state of the game.
     * 
     * @return the state of the game
     */
    public GameResult getResult() {
        if (countMissingLetters() == 0)
            return GameResult.SOLVED;
        else if (countFailedAttempts() == MAX_FAILED_ATTEMPTS)
            return GameResult.FAILED;
        else
            return GameResult.OPEN;
    }
}
