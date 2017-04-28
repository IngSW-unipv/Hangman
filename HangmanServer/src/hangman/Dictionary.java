/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package hangman;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * A generator of random words.
 * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class Dictionary {
    List<String> words;
    Random randomGenerator;
    
    /**
     * Initialize the dictionary by loading the words.
     */
    public Dictionary() {
        loadWords();
        randomGenerator = new Random();
    }
    
    private void loadWords() {
        String resourcesPath = "resources/words.txt";
        InputStream stream = getClass().getClassLoader().getResourceAsStream(resourcesPath);

        try (Scanner s = new Scanner(stream)) {
            words = new ArrayList<>();
            while (s.hasNext())
                words.add(s.next());
        }
    }
    
    /**
     * Randomly choose a word.
     * 
     * @return a random word.
     */
    public String pickWord() {
        int n = randomGenerator.nextInt(words.size());
        return words.get(n);
    }
}
