package lecture04AForLoopLab;

import java.util.Scanner;

public class P09LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i <= 2 * count; i++) {
            int j = Integer.parseInt(scanner.nextLine());

            if (i <= count) {
                leftSum += j;
            }
            if (i > count) {
                rightSum += j;
            }
        }

        if (leftSum == rightSum) {
            System.out.printf("Yes, sum = %d%n", leftSum);
        } else {
            System.out.printf("No, diff = %d%n", Math.abs(leftSum - rightSum));
        }
    }
}
