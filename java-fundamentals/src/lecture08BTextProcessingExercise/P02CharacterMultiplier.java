package lecture08BTextProcessingExercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int shorter = Math.min(input[0].length(), input[1].length());
        int longer = Math.max(input[0].length(), input[1].length());
        String longerString = "";

        if (input[0].length() <= input[1].length()) {
            longerString = input[1];
        } else {
            longerString = input[0];
        }

        int sum = 0;

        for (int i = 0; i < shorter; i++) {
            char first = input[0].charAt(i);
            char second = input[1].charAt(i);

            sum += first * second;
        }
        for (int i = shorter; i < longer; i++) {
            char symbol = longerString.charAt(i);

            sum += symbol;
        }

        System.out.println(sum);
    }
}
