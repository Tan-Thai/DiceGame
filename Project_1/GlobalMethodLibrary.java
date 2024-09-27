package Project_1;
import java.util.Scanner;

public class GlobalMethodLibrary {

    public static int setGameRounds(Scanner sc) {
        System.out.print("How many turns do you wish to play?: ");
        return checkIfNumber(sc);
    }

    public static int checkIfNumber(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.err.print("Invalid input, please write a number: ");
            sc.nextLine();
        }
        return sc.nextInt();
    }
}
