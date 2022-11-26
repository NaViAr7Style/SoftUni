package lecture08BTextProcessingExercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String user : usernames) {
            if (user.length() <= 3 || user.length() >= 16) {
                continue;
            }
            boolean isValid = true;
            for (int i = 0; i < user.length(); i++) {
                char symbol = user.charAt(i);

                if (!(Character.isLetterOrDigit(symbol) || symbol == '_' || symbol == '-')) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println(user);
            }
        }
    }
}
