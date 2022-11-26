package lecture08BTextProcessingExercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        int explosion = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (explosion > 0 && symbol != '>') {
                explosion--;
                continue;
            }

            if (symbol == '>') {
                explosion += Character.getNumericValue(input.charAt(i + 1));
            }

            result.append(symbol);
        }

        System.out.println(result);
    }
}
