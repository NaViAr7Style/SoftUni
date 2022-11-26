package lecture04CMethodsAdditionalExercises;

import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        tribonacci(n);
    }

    public static void tribonacci(int n) {
        int first = 1;
        int second = 1;
        int third = 2;

        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(1 + " " + 1);
        } else if (n == 3) {
            System.out.println(1 + " " + 1 + " " + 2);
        } else {
            System.out.printf("%d %d %d ", first, second, third);

            for (int i = 4; i <= n; i++) {
                int current = first + second + third;
                System.out.printf("%d ", current);
                first = second;
                second = third;
                third = current;
            }
        }
    }
}
