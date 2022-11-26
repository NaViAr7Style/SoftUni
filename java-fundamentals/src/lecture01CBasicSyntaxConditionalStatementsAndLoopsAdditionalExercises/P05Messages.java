package lecture01CBasicSyntaxConditionalStatementsAndLoopsAdditionalExercises;

import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder message = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(scanner.nextLine());

            if (input == 0) {
                message.append(" ");
                continue;
            }

            int digitCounter = 0;
            int number = input;
            while (number > 0) {
                digitCounter++;
                number /= 10;
            }

            int mainDigit = input % 10;
            int offset = (mainDigit - 2) * 3;

            if (mainDigit == 8 || mainDigit == 9) {
                offset++;
            }

            int letterIndex = offset + digitCounter - 1;

            char symbol = (char) (letterIndex + 97);

            message.append(symbol);
        }

        System.out.println(message);
    }
}
