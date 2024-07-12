package cipherbyteprojects;


import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();

        // Set the range of the generated number
        int minNumber = 1;
        int maxNumber = 100;

        // Set the maximum number of attempts
        int maxAttempts = 5;

        // Set the number of rounds
        int maxRounds = 3;

        // Initialize the score
        int score = 0;

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Number!");

        // Outer loop for rounds
        for (int round = 1; round <= maxRounds; round++) {
            // Generate a random number for this round
            int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;

            System.out.println("\nRound " + round + ":");
            System.out.println("I'm thinking of a number between " + minNumber + " and " + maxNumber + ". Guess it!");

            // Inner loop for attempts
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                // Check if the guess is correct
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    // Update the score for this round
                    score++;
                    break; // Exit the attempts loop
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low. Try again!");
                } else {
                    System.out.println("Your guess is too high. Try again!");
                }
            }

            // Check if the user reached the maximum attempts without guessing the number
            if (score == round - 1) {
                System.out.println("\nRound " + round + ": You couldn't guess the number. It was " + randomNumber);
            }
        }

        // Display final score
        System.out.println("\nGame Over!");
        System.out.println("Your final score: " + score + "/" + maxRounds);

        // Close the scanner
        scanner.close();
    }
}
