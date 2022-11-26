package lecture03CArraysAdditionalExercises;

import java.util.Scanner;

public class P03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = Integer.parseInt(scanner.nextLine());

        System.out.println(recursiveFibonacci(index));
    }

    public static int recursiveFibonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
}
