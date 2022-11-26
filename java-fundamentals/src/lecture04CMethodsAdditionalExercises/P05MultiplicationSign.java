package lecture04CMethodsAdditionalExercises;

import java.util.Scanner;

public class P05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println(signOf(first,second,third));
    }

    public static String signOf(int a, int b, int c) {
        if (a == 0 || b == 0 || c == 0) {
            return "zero";
        }

        int negativeCount = 0;

        if (a < 0) {
            negativeCount++;
        }

        if (b < 0) {
            negativeCount++;
        }

        if (c < 0) {
            negativeCount++;
        }

        if (negativeCount % 2 == 0) {
            return "positive";
        } else {
            return "negative";
        }
    }
}
