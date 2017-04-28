/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package hangman;

import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class ArtificialPlayer extends Player {

    Random randomGenerator;
    Logger log;

    public ArtificialPlayer() {
        randomGenerator = new Random();
        log = Logger.getLogger(ArtificialPlayer.class.getSimpleName());
    }
    
    @Override
    public char chooseLetter(Game r) {
        char c = (char) ('A' + randomGenerator.nextInt(26));
        log.info("Guess '" + c + "'");
        return c;
    }

    @Override
    public void update(Game r) {
        log.info(r.getKnownLetters() +  "   [" + r.getResult() + "]");
    }
}
