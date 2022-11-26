package lecture02BMultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        int sumPrimary = 0;
        int sumSecondary = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            sumPrimary += matrix[i][i];
            sumSecondary += matrix[i][matrix.length - 1 - i];
        }

        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }
}
