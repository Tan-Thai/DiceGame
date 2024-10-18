package Project_1.DiceGame;

import java.util.Scanner;
import java.text.MessageFormat;
import Project_1.GlobalMethodLibrary;

public class DiceGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean replay = false;

        System.out.println(
                "Welcome to this simple Dice game!\nThe game is based around you guessing what number your personal die has landed on.");
        System.out.print("To start off. ");
        Player player = setupUser(sc);

        do {

            coreGameProcess(sc, player);

            System.out.print("Do you want to play again? Y/N: ");
            replay = GlobalMethodLibrary.checkYesOrNo(sc);
            if (replay) {
                System.out.println("----------------------------------------------------");
            }
        } while (replay);

        System.out.println("--------------------------Thanks for playing!--------------------------");
        sc.close();
    }
    
    private static Player setupUser(Scanner sc) {
        System.out.print("What is your name?: ");
        String userInput = GlobalMethodLibrary.checkIfValidString(sc);
        Player player = new Player(userInput);

        System.out.print("How many sides will your die have?: ");
        player.addDie(GlobalMethodLibrary.checkIfNumber(sc));

        return player;
    }

    private static void coreGameProcess(Scanner sc, Player player) {
        int rounds = GlobalMethodLibrary.setGameRounds(sc);
        for (int i = 1; i <= rounds; i++) {
            userGuess(sc, player);
        }

        System.out.println("--------------------------Game End--------------------------");
        printResults(player, rounds);
    }

    private static void userGuess(Scanner sc, Player player) {
        player.rollDice();
        int userGuess = -1;
        int maxNumber = player.die.getNumberOfSides();
        
        System.out.print("\nPlease guess what your die rolled between 1-" + maxNumber + ": ");

        do {
            userGuess = GlobalMethodLibrary.checkIfNumber(sc);

            if (userGuess >= 1 && userGuess <= maxNumber) {
                break;
            } else {
                System.err.print("Invalid input, please enter a number between 1 and " + maxNumber + ": ");
            }
            
        } while (true);

        if (userGuess == player.getDieValue()) {
            player.increaseScore();
            System.out.println("You guessed right! Your current score is: *" + player.getScore() + "*");
        } else {
            System.out.println("You guessed wrong! The right number was: " + player.getDieValue());
        }
    }

    private static void printResults(Player player, int rounds) {
        // Separated the printing of results to make it cleaner + ease of extension for
        // the results calc
        // Slightly awkward with rounding as well due to the nature of how it rounds
        // towards 0.
        if (player.score > rounds / 2) {
            System.out.println(MessageFormat.format(
                    "\nYour total score in {0} round(s) with a {1} sided die is: *{2}*. Good job, {3}!",
                    rounds, player.die.getNumberOfSides(), player.score, player.name));
        } else {
            System.out.println(MessageFormat.format(
                    "\nYour total score in {0} round(s) with a {1} sided die is: *{2}*. Nice try, {3}!",
                    rounds, player.die.getNumberOfSides(), player.score, player.name));
        }
    }
}
