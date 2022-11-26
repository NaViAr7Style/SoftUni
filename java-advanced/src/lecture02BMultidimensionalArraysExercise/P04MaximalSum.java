package lecture02BMultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[3][3];

        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {
                int currentSum = get3By3MatrixSum(matrix, r, c);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    copyMatrix(subMatrix, matrix, r, c);
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        for (int[] arr : subMatrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void copyMatrix(int[][] subMatrix, int[][] matrix, int r, int c) {
        int rowCounter = 0;
        int colCounter = 0;

        for (int row = r; row < r + 3; row++) {
            for (int col = c; col < c + 3; col++) {
                subMatrix[rowCounter][colCounter] = matrix[row][col];
                colCounter++;
            }

            rowCounter++;
            colCounter = 0;
        }
    }

    private static int get3By3MatrixSum(int[][] matrix, int r, int c) {
        int sum = 0;

        for (int row = r; row < r + 3; row++) {
            for (int col = c; col < c + 3; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }
}
