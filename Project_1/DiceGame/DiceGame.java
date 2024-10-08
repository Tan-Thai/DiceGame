package Project_1.DiceGame;

import java.util.Scanner;
import java.text.MessageFormat;
import Project_1.GlobalMethodLibrary;

public class DiceGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char gameLoop = 'Y';

        System.out.println(
                "Welcome to this simple Dice game!\nThe game is based around you guessing what number your personal die has landed on.");
        System.out.print("To start off. ");

        while (gameLoop == 'Y'){
            coreGameProcess(sc);
            System.out.print("Do you want to play again? Y/N: ");
            GlobalMethodLibrary.clearScanner(sc);
            gameLoop = GlobalMethodLibrary.checkYesOrNo(sc);
        }
        
        System.out.println("--------------------------Thanks for playing!--------------------------");
        sc.close();
    }
    
    private static void coreGameProcess(Scanner sc){
        Player player = setupUser(sc);
        int rounds = GlobalMethodLibrary.setGameRounds(sc);
    
        // will loop back here on "rematch" if i decide to implement that.
        for (int i = 1; i <= rounds; i++) {
            userGuess(sc, player);
        }
    
        System.out.println("--------------------------Game End--------------------------");
        printResults(player, rounds);

    }

    private static Player setupUser(Scanner sc) {
        System.out.print("What is your name?: ");
        String userInput = sc.nextLine();
        Player player = new Player(userInput);

        System.out.print("How many sides will your die have?: ");
        player.addDie(GlobalMethodLibrary.checkIfNumber(sc));
        return player;
    }

    private static void userGuess(Scanner sc, Player player) {
        player.rollDice();

        System.out.print("\nPlease guess what your die rolled between 1-" + player.die.getNumberOfSides() + ": ");
        int userGuess = GlobalMethodLibrary.checkIfNumber(sc, player.die.getNumberOfSides());

        if (userGuess == player.getDieValue()) {
            player.increaseScore();
            System.out.println("You guessed right! Your current score is: *" + player.getScore() + "*");
        } else {
            System.out.println("You guessed wrong! The right number was: " + player.getDieValue());
        }
    }

    private static void printResults(Player player, int rounds) {
        // Separated the printing of results to make it cleaner + ease of extension for the results calc
        // Slightly awkward with rounding as well due to the nature of how it rounds towards 0.
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
