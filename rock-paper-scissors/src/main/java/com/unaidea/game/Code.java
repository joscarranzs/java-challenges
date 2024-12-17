package com.unaidea.game;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Code {
    private String playerOne = "Player 1";
    private String playerTwo = "Player 2";
    private int pointsPlayerOne = 0;
    private int pointsPlayerTwo = 0;
    private int attempts = 3;

    private String[] choices = {"rock", "paper", "scissors"};

    Random random = new Random();

    private int roll(String player) {
        int choice = random.nextInt(choices.length);
        System.out.println(player + " rolls a " + choices[choice]);

        return choice;
    }

    private void addPoints(String player) {
        if (player.equals(playerOne)) {
            pointsPlayerOne++;
        } else {
            pointsPlayerTwo++;
        }
    }

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
