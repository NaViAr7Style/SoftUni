package lecture04AMethodsLab;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        numberTriangle(input);
    }

    public static void numberTriangle(int a) {
        for (int i = 1; i <= a; i++) {
            printLine(1, i);
        }

        for (int i = a - 1; i >= 1; i--) {
            printLine(1, i);
        }
    }

    public static void printLine (int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
