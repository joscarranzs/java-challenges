package com.unaidea.game;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

/**
 * A simple rock-paper-scissors game implementation.
 * It simulates a match between two players with a limited number of attempts.
 */
public class Code {
    /** Player one's name. */
    private String playerOne = "Player 1";

    /** Player two's name. */
    private String playerTwo = "Player 2";

    /** Points scored by player one. */
    private int pointsPlayerOne = 0;

    /** Points scored by player two. */
    private int pointsPlayerTwo = 0;

    /** Number of rounds or attempts remaining. */
    private int attempts = 3;

    /** Choices available in the game: rock, paper, scissors. */
    private String[] choices = {"rock", "paper", "scissors"};

    /** Random instance used to generate player rolls. */
    Random random = new Random();

    /**
     * Simulates a roll (choice) for a player.
     *
     * @param player The name of the player rolling.
     * @return The index of the choice made (0: rock, 1: paper, 2: scissors).
     */
    private int roll(String player) {
        int choice = random.nextInt(choices.length);
        System.out.println(player + " rolls a " + choices[choice]);

        return choice;
    }

    /**
     * Adds a point to the specified player's score.
     *
     * @param player The name of the player to award points.
     */
    private void addPoints(String player) {
        if (player.equals(playerOne)) {
            pointsPlayerOne++;
        } else {
            pointsPlayerTwo++;
        }
    }

    /**
     * Evaluates the result of a round based on the players' choices.
     *
     * @param choicePlayerOne The choice index for player one.
     * @param choicePlayerTwo The choice index for player two.
     */
    private void evaluate(int choicePlayerOne, int choicePlayerTwo) {
        Map<String, String> rules = new HashMap<>();
        rules.put("rock", "scissors");
        rules.put("paper", "rock");
        rules.put("scissors", "paper");

        String optionPlayerOne = choices[choicePlayerOne];
        String optionPlayerTwo = choices[choicePlayerTwo];

        if (optionPlayerOne.equals(optionPlayerTwo)) {
            System.out.println("It's a tie! No one won this round!");
        } else if (rules.get(optionPlayerOne).equals(optionPlayerTwo)) {
            System.out.println(playerOne + " has won this round!");
            addPoints(playerOne);
        } else {
            System.out.println(playerTwo + " has won this round!");
            addPoints(playerTwo);
        }
    }

    /**
     * Starts the game loop, allowing the players to play multiple rounds.
     * The game continues until the specified number of attempts is exhausted
     * or the player chooses to exit.
     */
    public void play() {
        String choice;
        do {
            System.out.println("\n");
            System.out.println("1. Let's play a game of rock-paper-scissors!");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = System.console().readLine();
            } catch (Exception e) {
                System.out.println("Invalid choice!");
                continue;
            }

            if (choice.equals("1")) {
                System.out.println("\n");
                evaluate(roll(playerOne), roll(playerTwo));
                attempts--;
            } else if (choice.equals("2")) {
                System.out.println("\n");
                System.out.println("Bye!");
                System.exit(0);
            } else {
                System.out.println("\n");
                System.out.println("Invalid choice!");
                continue;
            }
        } while (attempts > 0);

        if (pointsPlayerOne > pointsPlayerTwo) {
            System.out.println("\n");
            System.out.println("Congratulations, " + playerOne + "! You have won the game.");
        } else if (pointsPlayerTwo > pointsPlayerOne) {
            System.out.println("\n");
            System.out.println("Congratulations, " + playerTwo + "! You have won the game.");
        } else {
            System.out.println("\n");
            System.out.println("It's a tie! No player claimed victory.");
        }
    }
}
