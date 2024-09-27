package Project_1.MultiplayerDiceGame;

import java.util.Scanner;
import Project_1.GlobalMethodLibrary;
import java.text.MessageFormat;
import java.util.ArrayList;

public class MultiDiceGame {
    public static void main(String[] args) {
        int rounds;
        ArrayList<Player> playerList;

        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Welcome to this multiplayer Dice game!\nThe game is based around getting the highest total number with the dice you roll.");
        playerList = initialize(sc);
        rounds = GlobalMethodLibrary.setGameRounds(sc);

        sc.nextLine(); //Legit hate these, removing this somehow skips the next nextline
        System.out.println("Press enter to start the first round");
        sc.nextLine();

        for (int i = 1; i <= rounds; i++) {
            takeTurn(playerList);
            Player test = playerList.get(0);
            System.out.println(test.getScore());
            if (i < rounds) {
                System.out.println("Round " + i + " done, press enter to continue to next round.");
            } else {
                System.out.println("Round " + i + " done, press enter to get the results.");
            }
            sc.nextLine();
        }

        System.out.println("--------------------------Game End--------------------------");
        sc.close();
    }

    private static ArrayList<Player> initialize(Scanner sc) {
        ArrayList<Player> players = new ArrayList<Player>();
        int playerCount;

        System.out.print("How many players are you?:");
        playerCount = GlobalMethodLibrary.checkIfNumber(sc);

        sc.nextLine();
        for (int i = 1; i <= playerCount; i++ ){
           players.add(setupUser(sc, i));
        }
        return players;
    }

    private static Player setupUser(Scanner sc, int playerCount) {
        System.out.print("Player "+ playerCount +", what is your name?: ");
        String userInput = sc.nextLine();
        Player player = new Player(userInput);

        System.out.print("How many dice will you have?: ");
        int diceCount = GlobalMethodLibrary.checkIfNumber(sc);

        // TODO: Add modularity to the creation of dice to allow players to change the side count.
        for (int i = 1; i <= diceCount; i++ ) {
            player.addDie();
        }

        sc.nextLine(); // clears scanner to avoid double error if user fails to input, idk why it happens - gotta research.
        return player;
    }

    private static void takeTurn(ArrayList<Player> players) {
        int totalDiceValue;
        for (Player player : players) {
            player.rollDice();

            totalDiceValue = player.getTotalDiceValue();
            player.increaseScore(totalDiceValue);
            System.out.println("The total value of all " + player.name +"'s "+ player.dice.size() +" dice is: " + totalDiceValue);
        }
    }

}
