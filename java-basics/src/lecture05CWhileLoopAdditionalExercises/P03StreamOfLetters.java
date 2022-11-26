package lecture05CWhileLoopAdditionalExercises;

import java.util.Scanner;

public class P03StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder expression = new StringBuilder();
        int counterN = 0;
        int counterO = 0;
        int counterC = 0;

        while (!input.equals("End")) {
            int asciiValue = input.charAt(0);

            if ((65 <= asciiValue && asciiValue <= 90) || (97 <= asciiValue && asciiValue <= 122)) {
                if (asciiValue == 99) {
                    if (counterC == 0) {
                        counterC++;
                    } else {
                        expression.append(input);
                    }
                } else if (asciiValue == 110) {
                    if (counterN == 0) {
                        counterN++;
                    } else {
                        expression.append(input);
                    }
                } else if (asciiValue == 111) {
                    if (counterO == 0) {
                        counterO++;
                    } else {
                        expression.append(input);
                    }
                } else {
                    expression.append(input);
                }
            }

            if (counterC == 1 && counterN == 1 && counterO == 1) {
                System.out.print(expression + " ");
                expression = new StringBuilder();
                counterN = 0;
                counterO = 0;
                counterC = 0;
            }

            input = scanner.nextLine();
        }
    }
}
