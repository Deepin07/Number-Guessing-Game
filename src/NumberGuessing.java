import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        int randomNumber = random.nextInt(100) + 1;
        int numberOfChances;
        int userGuess;
        boolean hasWon = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        System.out.println("Select Difficulty Level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (7 chances)");
        System.out.println("3. Hard (5 chances)");
        System.out.print("Enter your choice (1/2/3): ");
        int difficulty = scanner.nextInt();

        switch (difficulty) {
            case 1 -> {
                numberOfChances = 10;
                System.out.println("You have selected easy, You have 10 chances");
            }

            case 2 -> {
                numberOfChances = 7;
                System.out.println("You have selected medium, You have 7 chances");
            }
            case 3 -> {
                numberOfChances = 5;
                System.out.println("You have selected hard, You have 5 chances");
            }
            default -> {
                System.out.println("Invalid choice. Defaulting to Medium difficulty with 7 chances.");
                numberOfChances = 7;
            }
        }

        System.out.println("I'm thinking about a number between 1 and 100");

        for (int i = 0; i < numberOfChances; i++) {
            System.out.println("Enter your guess");
            userGuess = scanner.nextInt();

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please enter a number between 1 and 100");
            } else if (userGuess == randomNumber) {
                hasWon = true;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low");
            } else {
                System.out.println("Your guess is too high");
            }

            System.out.println("You have " + (numberOfChances - i - 1) + " chances");
        }

        if (hasWon) {
            System.out.println("You have guessed the number correctly");
        } else {
            System.out.println("Sorry, You ran out of chances the number was " + randomNumber + ".");
        }

        scanner.close();

    }
}
