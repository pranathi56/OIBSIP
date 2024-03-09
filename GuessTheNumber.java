package test;
import java.util.*;

public class GuessTheNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play the Number Guessing Game");

        
        int totalScore = 0;
        int rounds = 0;

        
        while (true) {
            System.out.println("\nRound " + (rounds + 1));

            
            System.out.println("Enter lower bound:");
            int lowerBound = sc.nextInt();
            System.out.println("Enter upper bound:");
            int upperBound = sc.nextInt();
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            
            System.out.println("Enter the number of attempts to guess:");
            int maxAttempts = sc.nextInt();

            int count = 0;

            
            while (count < maxAttempts) {
                count++;
                System.out.println("Attempt " + count + ": Enter your guess:");
                int userGuess = sc.nextInt();

                if (targetNumber == userGuess) {
                    int roundScore = calculateScore(maxAttempts, count);
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed in " + count + " attempts.");
                    System.out.println("Round Score: " + roundScore + " | Total Score: " + totalScore);
                    break;
                } else if (targetNumber > userGuess) {
                    System.out.println("The guessed number is smaller.");
                } else {
                    System.out.println("The guessed number is higher.");
                }
            }

            
            System.out.println("The correct number was: " + targetNumber);

            
            System.out.println("Do you want to play another round? (yes/no)");
            String playAgain = sc.next().toLowerCase();

            if (playAgain.equals("no")) {
                System.out.println("Thanks for playing! Final Score: " + totalScore);
                break;
            }

            rounds++;
        }

        sc.close();
    }

    private static int calculateScore(int maxAttempts, int attempts) {
        
        int baseScore = 100; 
        int deduction = (maxAttempts - attempts) * 10; 
        return Math.max(0, baseScore - deduction); 
    }
}
