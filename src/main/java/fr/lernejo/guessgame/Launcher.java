package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        try {
            if (args[0].equals("-interactive")) {
                Player player = new HumanPlayer();
                Simulation game = new Simulation(player);

                SecureRandom random = new SecureRandom();
                long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

                game.initialize(randomNumber, Long.MAX_VALUE);
                game.loopUntilPlayerSucceed();
            } else if (args[0].equals("-auto")) {
                Player player = new ComputerPlayer();
                Simulation game = new Simulation(player);

                SecureRandom random = new SecureRandom();
                long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

                game.initialize(randomNumber, Long.parseLong(args[1]));
                game.loopUntilPlayerSucceed();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Usage:");
            System.out.println("-interactive    : lets the player play the game");
            System.out.println("-auto <max>     : lets the computer play the game with <max> being the maximum tries");
        }
    }
}
