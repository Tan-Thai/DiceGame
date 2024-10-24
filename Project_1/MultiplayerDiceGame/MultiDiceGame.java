package Project_1.MultiplayerDiceGame;

import Project_1.GlobalMethodLibrary;
import java.util.Scanner;
import java.util.ArrayList;

public class MultiDiceGame {
    public static void main(String[] args) {
        int rounds;
        ArrayList<Player> playerList = new ArrayList<Player>();
        ArrayList<Player> winnerList;

        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Welcome to this multiplayer Dice game!\nThe game is based around getting the highest total number with the dice you roll.");
        playerList = initialize(sc);
        rounds = GlobalMethodLibrary.setGameRounds(sc);


        System.out.print("\nPress enter to start the first round");
        GlobalMethodLibrary.clearScanner(sc);

        for (int i = 1; i <= rounds; i++) { //can break out into its own method here.
            System.out.println("-------------------------------------");
            takeTurn(playerList);

            if (i < rounds) {
                System.out.print("Round " + i + " done, press enter to continue to next round.");
            } else {
                System.out.print("Round " + i + " done, press enter to get the results.");
            }

            GlobalMethodLibrary.clearScanner(sc);
        }

        winnerList = getWinners(playerList);
        printWinners(winnerList);

        System.out.println("-------------------------- Game End --------------------------");
        sc.close();
    }

    private static ArrayList<Player> initialize(Scanner sc) {
        ArrayList<Player> players = new ArrayList<Player>();
        int playerCount;

        System.out.print("How many players are you?: ");
        playerCount = GlobalMethodLibrary.checkIfNumber(sc);

        for (int i = 1; i <= playerCount; i++ ){
           players.add(setupUser(sc, i));
        }
        return players;
    }

    private static Player setupUser(Scanner sc, int playerCount) {
        System.out.print("\nPlayer "+ playerCount +", what is your name?: ");
        String userInput = GlobalMethodLibrary.checkIfValidString(sc);
        Player player = new Player(userInput);

        System.out.print("How many dice will you have?: ");
        int diceCount = GlobalMethodLibrary.checkIfNumber(sc);

        // TODO: Add modularity to the creation of dice to allow players to change the side count.
        for (int i = 1; i <= diceCount; i++ ) {
            player.addDie();
        }
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

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winnerList = new ArrayList<Player>();
        int highestScore = 0;
        
        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }

        for (Player player : players) {
            if (player.getScore() == highestScore) {
                winnerList.add(player);
            }
        }

        return winnerList;
    }

    private static void printWinners(ArrayList<Player> winnerList) {
        System.out.println("-------------------------- Results --------------------------");
        System.out.println("The winner(s) with " + winnerList.get(0).score + " points are: ");
        for (Player player : winnerList) {
            System.out.println(player.name + "!");
        }
        System.out.println("Congratulations!");
    } 
}
