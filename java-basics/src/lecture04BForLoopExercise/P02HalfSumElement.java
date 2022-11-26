package lecture04BForLoopExercise;

import java.util.Scanner;

public class P02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n ; i++) {
            int j = Integer.parseInt(scanner.nextLine());
            sum += j;

            if (max < j) {
                max = j;
            }
        }

        sum -= max;

        if (max == sum) {
            System.out.printf("Yes%nSum = %d%n", max);
        } else {
            System.out.printf("No%nDiff = %d%n", Math.abs(sum - max));
        }
    }
}
