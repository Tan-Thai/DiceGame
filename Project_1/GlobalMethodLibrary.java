package Project_1;
import java.util.Scanner;

public class GlobalMethodLibrary {

    public static int setGameRounds(Scanner sc) {
        System.out.print("How many turns do you wish to play?: ");
        return checkIfNumber(sc);
    }

    public static String checkIfValidString (Scanner sc) {
        String userInput = "";
        do {
            userInput = sc.nextLine();
            if (userInput != "") {
                return userInput;
            }
            System.err.print("Please enter a name: ");
        } while (true); //forced loop
    }

    public static int checkIfNumber(Scanner sc) {
        int userInput = -1; //-1 to always give error when there's no input

        while (true) { //forced loop in while
            if (sc.hasNextInt()) {
                userInput = sc.nextInt();
                if (userInput > 0) {
                    clearScanner(sc); 
                    return userInput;
                }
            } else {
                sc.next(); 
            }
            System.err.print("Invalid input, please enter a number above 0: ");
        }
    }

    public static boolean checkYesOrNo(Scanner sc) {
        do {
            String inputString = sc.nextLine().trim();
            if (inputString.length() == 1) {
                char choice = inputString.charAt(0);
                choice = Character.toUpperCase(choice);

                switch (choice) {
                    case 'Y':
                        return true;
                    case 'N':
                        return false;
                }
            }
            System.err.print("Invalid input, please enter either Y or N: ");
        } while (true); //forced loop in do while
    }

    public static void clearScanner(Scanner sc) {
        if(sc.hasNextLine()){
            sc.nextLine();
        }
    }
}
