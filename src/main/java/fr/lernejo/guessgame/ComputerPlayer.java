package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;
import java.util.ArrayList;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("computer");
    private final ArrayList<Long> list = new ArrayList<>();
    private int f;
    private int l;
    private int mid;

    public ComputerPlayer() {
        f = 0;

        for (long i = 0; i < 100; i++) {
            list.add(i);
        }

        l = list.size() - 1;
        mid = (f + l)/2;
    }

    @Override
    public long askNextGuess() {
        long guess = list.get(mid);
        logger.log("Guessed " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) {
            logger.log("The number is lower.");
            l = mid - 1;
        } else {
            logger.log("The number is greater.");
            f = mid + 1;
        }
        mid = (f + l)/2;
    }
}
