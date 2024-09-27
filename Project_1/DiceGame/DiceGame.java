import java.util.Scanner;
import java.text.MessageFormat;

public class DiceGame {
    public static void main(String[] args) {
        int rounds;
        Player player;

        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Welcome to this simple Dice game!\nThe game is based around you guessing what the you have rolled with your personal die.");
        System.out.print("To start off. ");

        player = setupUser(sc);
        rounds = setGameRounds(sc);

        // will loop back here on "rematch"
        for (int i = 0; i <= rounds; i++) {
            sc.nextLine();
            userGuess(sc, player);
        }

        System.out.println("--------------------------Game End--------------------------");
        if (player.score >= rounds / 2) {
            System.out.println(MessageFormat.format(
                    "\nYour total score in {0} round(s) against a {1} sided die is: *{2}*. Good job, {3}!",
                    rounds, player.die.getNumberOfSides(), player.score, player.name));
        } else {
            System.out.println(MessageFormat.format(
                    "\nYour total score in {0} round(s) against a {1} sided die is: *{2}*. Nice try, {3}!",
                    rounds, player.die.getNumberOfSides(), player.score, player.name));
        }
        sc.close();
    }

    private static Player setupUser(Scanner sc) {
        String userInput;
        Player player;
        System.out.print("What is your name?: ");
        userInput = sc.nextLine();
        player = new Player(userInput);

        System.out.print("How many sides will your die have?: ");
        player.addDie(checkIfNumber(sc));

        sc.nextLine(); // clears scanner to avoid double error if user fails to input, idk why it
                       // happens - gotta research.
        return player;
    }

    private static int setGameRounds(Scanner sc) {
        System.out.print("How many turns do you wish to play?: ");
        return checkIfNumber(sc);
    }

    private static void userGuess(Scanner sc, Player player) {
        int userGuess;
        player.rollDice();

        System.out.print("\nPlease guess what your die rolled between 1-" + player.die.getNumberOfSides() + ": ");
        userGuess = checkIfNumber(sc);

        if (userGuess == player.getDieValue()) {
            player.increaseScore();
            System.out.println("You guessed right! Your current score is: *" + player.getScore() + "*");
        } else {
            System.out.println("You guessed wrong! The right number was: " + player.getDieValue());
        }
    }

    public static int checkIfNumber(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.err.print("Invalid input, please write a number: ");
            sc.nextLine();
        }
        return sc.nextInt();
    }
}
