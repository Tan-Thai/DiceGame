package Project_1.PigGame;

import Project_1.GlobalMethodLibrary;
import java.util.Scanner;
import java.util.ArrayList;

public class PigGame {
    public static void main(String[] args) {
        ArrayList<Player> playerList = new ArrayList<Player>();
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "\nWelcome to this Pig Game, where 2 or more people contest against each other to reach 100 stocked points first!\n"
                        +
                        "Each player will have their turn to roll their die, accumulating points before stocking it when their turn ends.\n"
                        +
                        "A player can keep their turn and continue rolling after each roll but it comes with a risk.\n"
                        +
                        "If the player rolls a 1 at any time, then their turn will forcefully end and all points accumulated this round will be lost.\n"
                        +
                        "With the explanation done, lets proceed with the game!\n");

        playerList = initialize(sc);

        do {
            gameLoop(sc, playerList);
        } while (!winConditionReached(playerList)); // forever loop until winner reached

        System.out.println(
                "-------------------------- Someone reached " + winCondition() + " points! --------------------------");
        printResult(playerList);

        System.out.println("-------------------------- Game End --------------------------");
        sc.close();

    }

    private static ArrayList<Player> initialize(Scanner sc) {
        ArrayList<Player> players = new ArrayList<Player>();
        int playerCount;

        do {
            System.out.print("How many players are you?: ");
            playerCount = GlobalMethodLibrary.checkIfNumber(sc);

            if (playerCount < 2) { // being lazy here and just adding a quick if statement instead of adjusting
                                   // checkIfNumber for this.
                System.out.println("Please enter an amount of 2 or more, thank you.\n");
            }
        } while (playerCount < 2);

        for (int i = 1; i <= playerCount; i++) {
            players.add(setupUser(sc, i));
        }
        return players;
    }

    private static Player setupUser(Scanner sc, int playerCount) {
        System.out.print("\nPlayer " + playerCount + ", what is your name?: ");
        String userInput = GlobalMethodLibrary.checkIfValidString(sc);
        Player player = new Player(userInput);
        return player;
    }

    private static void gameLoop(Scanner sc, ArrayList<Player> playersList) { // had to break it out due to a large
                                                                              // amount of for/do while nesting.
                                                                              // (helps readability for me)
        for (Player player : playersList) {
            boolean playerGoesAgain = false;
            int unsecuredPoints = 0;

            System.out.println("-------------------------------------------");
            System.out.print(player.name + "'s turn! Press enter to roll the first die!");
            GlobalMethodLibrary.clearScanner(sc);

            do {
                player.die.roll();
                int dieValue = player.getDieValue();

                if (dieValue == 1) {
                    System.out.println("You rolled a 1! You lose all your unsecured points and your turn is over!");
                    unsecuredPoints = 0;
                    break;
                }

                unsecuredPoints += dieValue; // can add an if statement here to check if the roll itself would push the
                                             // player to winning and jump out to win, but ill hold off doing it.

                System.out.println(
                        "\nYou rolled a " + dieValue + " for a total of " + unsecuredPoints + " points and " +
                        player.score + " saved points.");
                System.out.print("Do you wish to take the risk and roll again?(Y/N): ");
                playerGoesAgain = GlobalMethodLibrary.checkYesOrNo(sc);

            } while (playerGoesAgain);

            player.increaseScore(unsecuredPoints);

            if (winConditionReached(playersList)) {
                break;
            }
        }
    }

    private static void printResult(ArrayList<Player> playerList) {
        for (Player player : playerList) {
            if (player.score >= winCondition()) {
                System.out.println(
                        "Congratulations " + player.name + "! You won the game with a total score of: " + player.score);
            }
        }
    }

    private static boolean winConditionReached(ArrayList<Player> playerList) {
        for (Player player : playerList) {
            if (player.score >= winCondition()) { // the score that is needed to win
                return true;
            }
        }
        return false;
    }

    private static int winCondition() { // streamlining location for the "winning" score to avoid human error.
        return 20;
    }
}
