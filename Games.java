package ca.bcit.comp1510.lab08;

import java.util.Scanner;
import java.util.Random;

/**
 * Games.
 * Building a game using loops and the Random class.
 * 
 * @author Sandhu, Avneet asandhu190@my.bcit.ca
 * @version 2021-03-22
 */
public class Games {
    
    /** Users score. */
    private int score;
    
    /** To get input from the user. */
    private Scanner scan;
    
    /** To be used in the game. */
    private Random random;
    
    /**
     * Constructs a Games object by defining the score, Scanner, and Random 
     * objects.
     */
    public Games() {
        score = 0;
        scan = new Scanner(System.in);
        random = new Random();
    }
    
    /**
     * Plays the game.
     */
    public void play() {
        int choice = 0;

        final int three = 3;
        final int four = 4;
        
        while (choice != four) {
            System.out.print("Welcome to the Games program!\nMake your choice "
                    + "(enter a number):\n1. See your score\n2. Guess a number"
                    + "\n3. Play Rock, Paper, Scissors\n4. Quit\n> ");
            
            if (!scan.hasNextInt()) {
                scan.next();
                System.out.println("This is an invalid input. Enter a number"
                        + " from 1-4");
            
            } else  {
                choice = scan.nextInt();
            
            
                if (choice < 0 || choice > four) {
                    System.out.println("That's not a valid choice!");
                } else {
                    switch (choice) {
                        case 1:
                            System.out.println("Your score is: " + score);
                            break;
                        case 2:
                            guessANumber();
                            break;
                        case three:
                            rockPaperScissors();
                            break;
                        default:
                            return;
                    }
                }
            }
        }
    }
    
    /**
     * User guesses a randomly generated number between 0-100 inclusive. The 
     * game tells the user if their guess if too high or too low. The user keeps
     * guessing until they get the number right. If the user guesses within 5 
     * guesses, 5 points get added to their score.
     */
    public void guessANumber() {
        final int maxNumber = 101;
        int number = random.nextInt(maxNumber);
        int timesGuessed = 0;
        int guess = maxNumber;
        final int maxGuess = 5;
        
        System.out.println("I've picked a random number between 0 and 100\nCan"
                + " you guess it?");
        
        while (guess != number) {
            System.out.println("Guess the number!");
            
            if (!scan.hasNextInt()) {
                scan.next();
                System.out.println("This is an invalid input. Enter a number "
                        + "from 0-100");
            } else  {
                guess = scan.nextInt();
                
                if (guess > number) {
                    System.out.println("Too high, guess again!");
                } else if (guess < number) {
                    System.out.println("Too low, guess again!");
                }
                
                timesGuessed++;
            }
        }
        
        System.out.println("RIGHT!");
        
        if (timesGuessed <= maxGuess) {
            score += maxGuess;
            System.out.println("Five points!");
        }
        return;
    }
    
    /**
     * Plays the classic Canadian game Rock, Paper, Scissors.
     */
    public void rockPaperScissors() {
        final int three = 3;
        // 0 = rock, 1 = paper, 2 = scissors
        int option = random.nextInt(three);
        String guess;
        
        String right = new String();
        switch (option) {
            case 0:
                right = "Rock";
                break;
            case 1:
                right = "Paper";
                break;
            default:
                right = "Scissors";
        }
        
        System.out.println("I've picked one of ROCK, PAPER, and SCISSORS");
        System.out.println("Which one do you choose?");
        guess = scan.next();
        
        while (!guess.equalsIgnoreCase("ROCK") 
                && !guess.equalsIgnoreCase("PAPER") 
                && !guess.equalsIgnoreCase("SCISSORS")) {
            
            System.out.println("That's not a valid choice! Try again!");
            guess = scan.next();
        }
        
        if (right.equalsIgnoreCase(guess)) {
            System.out.println("It's a tie! I also picked " + right);
        } else if ((right.equals("Rock") && guess.equalsIgnoreCase("SCISSORS")) 
                || (right.equals("Paper") && guess.equalsIgnoreCase("ROCK"))
                || (right.equals("Scissors") 
                        && guess.equalsIgnoreCase("PAPER"))) {
            System.out.println("Nope, I picked " + right);
        } else if (right.equals("Rock") && guess.equalsIgnoreCase("PAPER")) {
            System.out.println("Yes! Paper wraps rock");
        } else if (right.equals("Paper") 
                && guess.equalsIgnoreCase("SCISSORS")) {
            System.out.println("Yes! Scissors cut paper");
        } else if (right.equals("Scissors") && guess.equalsIgnoreCase("ROCK")) {
            System.out.println("Yes! Rock smashes scissors");
        }
    }
}
