package lecture04CForLoopAdditionalExercises;

import java.util.Scanner;

public class P08EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int sum1 = num1 + num2;
        int diff = 0;
        int maxDiff = 0;

        for (int i = 2; i <= n; i++) {
            num1 = Integer.parseInt(scanner.nextLine());
            num2 = Integer.parseInt(scanner.nextLine());

            int sum2 = num1 + num2;
            diff = Math.abs(sum1 - sum2);
            sum1 = sum2;

            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }

        if (maxDiff == 0) {
            System.out.printf("Yes, value=%d", sum1);
        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}
