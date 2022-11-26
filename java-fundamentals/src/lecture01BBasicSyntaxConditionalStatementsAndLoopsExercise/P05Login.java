package lecture01BBasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String password = "";

        for (int i = (username.length() - 1); i >= 0; i--) {
            password = password + username.charAt(i);
        }

        String input = scanner.nextLine();
        int attemptCounter = 0;
        boolean isBlocked = false;

        while (!input.equals(password)) {
            attemptCounter++;
            if (attemptCounter > 3) {
                isBlocked = true;
                break;
            }

            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }

        if (isBlocked) {
            System.out.printf("User %s blocked!", username);
        } else {
            System.out.printf("User %s logged in.", username);
        }
    }
}
