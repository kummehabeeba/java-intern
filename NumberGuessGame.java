import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        int targetNumber = rand.nextInt(100) +1;
        int guessedNumber;
        int tries = 0;

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to find it!");

        do {
            System.out.print("Enter your guess: ");
            while (!input.hasNextInt()) { 
                System.out.println("Invalid input! Please enter a number.");
                input.next(); 
            }
            guessedNumber = input.nextInt();
            tries++;

            if (guessedNumber < targetNumber) {
                System.out.println("Too low! Give it another shot.");
            } else if (guessedNumber > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Bravo! You got it in " + tries + " tries.");
            }
        } while (guessedNumber != targetNumber);

        input.close();
    }
}
