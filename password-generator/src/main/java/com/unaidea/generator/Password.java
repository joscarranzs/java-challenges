package com.unaidea.generator;

import java.util.Random;

/**
 * The {@code Password} class provides functionality to generate random passwords
 * with customizable length and optional inclusion of special characters.
 * 
 * This class uses two predefined character sets: one containing alphanumeric
 * characters and another that includes additional special characters. Users can
 * generate passwords by specifying the desired length and whether to include
 * special characters.
 * 
 * The class also includes a {@code run()} method that provides an interactive
 * console-based interface for generating passwords.
 * 
 * @author Jose Carranza
 * @version 1.0
 */
public class Password {

    /** Character set containing only alphanumeric characters. */
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /** Character set containing alphanumeric characters and special characters. */
    private static final String CHARS_WITH_SPECIAL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;':,./<>?";

    /** Default password length. */
    private int length = 8;

    /**
     * Generates a random password of the specified length.
     *
     * @param length      the length of the password to generate. Must be greater than 0.
     * @param withSpecial true to include special characters, false otherwise.
     * @return a randomly generated password as a String.
     */
    private String generate(int length, boolean withSpecial) {
        this.length = length;
        int index = 0;

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        if (withSpecial) {
            for (int i = 0; i < length; i++) {
                index = random.nextInt(CHARS_WITH_SPECIAL.length());
                sb.append(CHARS_WITH_SPECIAL.charAt(index));
            }
        } else {
            for (int i = 0; i < length; i++) {
                index = random.nextInt(CHARS.length());
                sb.append(CHARS.charAt(index));
            }
        }

        return sb.toString();
    }

    /**
     * Provides an interactive console-based interface for generating passwords.
     * 
     * Prompts the user to specify the password length and whether to include
     * special characters. Validates the user input and generates a password based
     * on the provided specifications.
     */
    public void run() {
        do {
            try {
                System.out.println("Welcome to Password Generator!");
                System.out.print("Length: ");
                length = Integer.parseInt(System.console().readLine());

                if (length < 1) {
                    System.out.println("Length must be greater than 0.");
                    continue;
                }

                System.out.print("Include special characters (y/n): ");
                String answer = System.console().readLine();

                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("Your password is: " + generate(length, true));
                    break;
                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("Your password is: " + generate(length, false));
                    break;
                } else {
                    System.out.println("Invalid answer.");
                    continue;
                }

            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }
        } while (true);
    }
}
