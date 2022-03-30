//<Qiancheng Li>
//<11/06/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #5>
//
//This program runs a guessing game that asks 
//the player to guess a random number and reports
//the statistics of the game.
import java.util.*;

public class GuessingGame {
    // Set the value of the maximum number Random r can generate.  
    public static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Random rand = new Random(7);
        Scanner console = new Scanner(System.in);
        char first = 'y';
        int numGame = 0;
        int singleGuess = 0;
        int totalGuess = 0;
        int minGuess = 1000000;
        while (first == 'y') {
            numGame++;
            singleGuess = singleGame(rand, console);
            totalGuess += singleGuess;
            minGuess = Math.min(minGuess, singleGuess);
            System.out.print("Do you want to play again? ");
            String response = console.next();
            first = response.toLowerCase().charAt(0);
            System.out.println();            
        }
        statistics(numGame, totalGuess, minGuess);
    }
    
    // Produce the haiku at the beginning.
    public static void haiku() {
        System.out.println("There's a number now");
        System.out.println("Guess it right to win the game");
        System.out.println("though you get nothing");
        for (int line = 0; line < 3; line++) {
            System.out.println();
        }
    }

    // Run single game of guessing a random number.
    // Return the number of guesses.
    // Parameters:
    //    Random rand: the tool to generate a random number as the answer
    //    Scanner console: the scanner to read user input   
    public static int singleGame(Random rand, Scanner console) {
        System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
        int answer = rand.nextInt(MAX_VALUE) + 1;
        int guess = 0;
        int count = 0;
        while (guess != answer) {
            count++;
            System.out.print("Your guess? ");
            guess = console.nextInt();
            if (guess > answer) {
                System.out.println("It's lower.");
            } else if (guess < answer) {
                System.out.println("It's higher.");
            }                       
        }
        if (count == 1) {
            System.out.println("You got it right in " + count + " guess!");               
        } else {
            System.out.println("You got it right in " + count + " guesses!"); 
        }   
        return count;       
    }

    // Report statistics of guessing games.
    // Parameters:
    //    int numGame: the number of times of games played in total
    //    int totalGuess: the number of guesses make in all games
    //    int minGuess: the minimum number of guesses made to win in all games
    public static void statistics(int numGame, int totalGuess, int minGuess) {
        System.out.println("Overall results:");
        System.out.println("Total games   = " + numGame);
        System.out.println("Total guesses = " + totalGuess);
        System.out.println("Guesses/game  = " + round1(totalGuess / (numGame * 1.0)));
        System.out.println("Best game     = " + minGuess);
    }
    
    // Round the number to its first decimal place.
    // Return the rounded number.
    // Parameter:
    //    double num: the number to be rounded
    public static double round1 (double num) {
        return Math.round(num * 10.0) / 10.0;
    }
}
