package lecture04AForLoopLab;

import java.util.Scanner;

public class P08NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= count; i++) {
            int j = Integer.parseInt(scanner.nextLine());

            if (max < j) {
                max = j;
            }
            if (min > j) {
                min = j;
            }
        }

        System.out.printf("Max number: %d%n", max);
        System.out.printf("Min number: %d%n", min);
    }
}
