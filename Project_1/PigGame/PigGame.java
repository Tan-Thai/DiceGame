package Project_1.PigGame;

import Project_1.GlobalMethodLibrary;
import java.util.Scanner;
import java.util.ArrayList;

public class PigGame {
    public static void main(String[] args) {
        ArrayList<Player> playerList = new ArrayList<Player>();

        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Welcome to this Pig Game, where 2 or more people contest against each other to reach 100 stocked points first!");
        System.out.println(
                "Each player will have their turn to roll their die, accumulating points before stocking it when their turn ends." +
                "\nA player can keep their turn and continue rolling after each roll but it comes with a risk." +
                "\nIf the player rolls a 1 at any time, then their turn will forcefully end and all points accumulated this round will be lost." +
                "\nWith the explanation done, lets proceed with the game!\n");
        playerList = initialize(sc);

        for (Player player : playerList) {
            System.out.println(player.name);
        }
        System.out.println("-------------------------- Game End --------------------------");
    }

    private static ArrayList<Player> initialize(Scanner sc) {
        ArrayList<Player> players = new ArrayList<Player>();
        int playerCount;

        System.out.print("How many players are you?: ");
        playerCount = GlobalMethodLibrary.checkIfNumber(sc);

        sc.nextLine();
        for (int i = 1; i <= playerCount; i++) {
            players.add(setupUser(sc, i));
        }
        return players;

    }

    private static Player setupUser(Scanner sc, int playerCount) {
        System.out.print("Player " + playerCount + ", what is your name?: ");
        String userInput = sc.nextLine();
        Player player = new Player(userInput);

        sc.nextLine();
        return player;
    }
}
