package lecture04AForLoopLab;

import java.util.Scanner;

public class P10OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 1; i <= count; i++) {
            int j = Integer.parseInt(scanner.nextLine());

            if (i % 2 == 0) {
                evenSum += j;
            } else {
                oddSum += j;
            }
        }

        if (oddSum == evenSum) {
            System.out.printf("Yes%nSum = %d%n", evenSum);
        } else {
            System.out.printf("No%nDiff = %d%n", Math.abs(evenSum - oddSum));
        }
    }
}
