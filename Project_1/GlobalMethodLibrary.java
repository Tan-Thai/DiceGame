package Project_1;
import java.util.Scanner;

public class GlobalMethodLibrary {

    public static int setGameRounds(Scanner sc) {
        System.out.print("How many turns do you wish to play?: ");
        return checkIfNumber(sc);
    }

    public static int checkIfNumber(Scanner sc) { // im losing the plot, heck these clear lines.
        int userInput;

        do {
            while (!sc.hasNextInt()) {
                System.err.print("Invalid input, please write a number: ");
                sc.nextLine();
            }

            userInput = sc.nextInt();

            if (userInput < 1) {
                System.err.print("Invalid input, please enter a number above 0: ");
                sc.nextLine();
            }

        } while (userInput < 1);
        clearScanner(sc);
        return userInput;
    }

    public static char checkYesOrNo(Scanner sc) {
        do {
            String inputString = sc.nextLine().trim();
            if (inputString.length() == 1) {
                char choice = inputString.charAt(0);
                choice = Character.toUpperCase(choice);

                if ((choice == 'Y' || choice == 'N')) {
                    return choice;
                }
            }
            System.err.print("Invalid input, please enter either Y or N: ");
        } while (true); // tvingar en loop tills användaren har skrivit rätt.
    }

    public static void clearScanner(Scanner sc) {
        if(sc.hasNextLine()){
            sc.nextLine();
        }
    }
}
