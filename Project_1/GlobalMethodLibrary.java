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

    public static char checkIfChar(Scanner sc) {
        do {
            String inputString = sc.nextLine().trim();
            if (inputString.length() == 1) {
                char choice = inputString.charAt(0);
                choice = Character.toUpperCase(choice);

                if ((choice == 'Y' || choice == 'N')) {
                    return choice;
                }
            }
            System.out.println("Invalid input, please enter either Y or N.");
        } while (true); // tvingar en loop tills användaren har skrivit rätt.
    }
}
