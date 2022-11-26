package lecture08BTextProcessingExercise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder nonRepeatingChars = new StringBuilder();

        if (input.length() == 1) {
            System.out.println(input);
            return;
        }

        nonRepeatingChars.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            char lastSymbol = nonRepeatingChars.charAt(nonRepeatingChars.length() - 1);

            if (currentSymbol != lastSymbol) {
                nonRepeatingChars.append(currentSymbol);
            }
        }

        System.out.println(nonRepeatingChars);
    }
}
