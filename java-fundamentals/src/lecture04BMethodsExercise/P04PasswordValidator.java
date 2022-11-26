package lecture04BMethodsExercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        isValidPass(password);
    }

    public static void isValidPass(String pass) {
        boolean isValid = true;

        if (pass.length() < 6 || pass.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }

        for (int i = 0; i < pass.length(); i++) {
            char currentSymbol = pass.charAt(i);

            if (!Character.isLetterOrDigit(currentSymbol)) {
                System.out.println("Password must consist only of letters and digits");
                isValid = false;
                break;
            }
        }

        int digitCounter = 0;

        for (int i = 0; i < pass.length(); i++) {
            char currentSymbol = pass.charAt(i);

            if (Character.isDigit(currentSymbol)) {
                digitCounter++;

                if (digitCounter == 2) {
                    break;
                }
            }
        }

        if (digitCounter < 2) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }

        if (isValid) {
            System.out.println("Password is valid");
        }
    }
}
