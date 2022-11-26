package lecture08BTextProcessingExercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String s : input) {
            char firstLetter = s.charAt(0);
            char lastLetter = s.charAt(s.length() - 1);
            double number = Double.parseDouble(s.substring(1, s.length() - 1));

            int firstLetterAlphabetPosition = (int) Character.toLowerCase(firstLetter) - 96;
            int lastLetterAlphabetPosition = (int) Character.toLowerCase(lastLetter) - 96;

            if (Character.isUpperCase(firstLetter)) {
                number /= firstLetterAlphabetPosition;
            } else {
                number *= firstLetterAlphabetPosition;
            }

            if (Character.isUpperCase(lastLetter)) {
                number -= lastLetterAlphabetPosition;
            } else {
                number += lastLetterAlphabetPosition;
            }

            sum += number;
        }

        System.out.printf("%.2f%n", sum);
    }
}
