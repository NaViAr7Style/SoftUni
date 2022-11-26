package lecture02BMultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int loopCounter = Math.min(rows, cols);

        for (int i = 1; i <= loopCounter; i++) {
            int r = matrix.length - 1;

            for (int c = matrix[0].length - i; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
                r--;
            }
            System.out.println();
        }

        loopCounter = Math.abs(rows - cols);

        if (rows > cols) {

            for (int i = 1; i <= loopCounter; i++) {
                int r = matrix.length - i -1;

                for (int c = 0; c < matrix[0].length; c++) {
                    System.out.print(matrix[r][c] + " ");
                    r--;
                }
                System.out.println();
            }
            
        } else if (rows < cols){

            for (int i = 1; i <= loopCounter; i++) {
                int r = matrix.length - 1;

                for (int c = cols - rows - i; c <= matrix[0].length - i -1; c++) {
                    System.out.print(matrix[r][c] + " ");
                    r--;
                }
                System.out.println();
            }
        }

        loopCounter = Math.min(rows, cols) - 1;

        for (int i = 1; i <= loopCounter; i++) {
            int r = loopCounter - i;

            for (int c = 0; c <= loopCounter - i; c++) {
                System.out.print(matrix[r][c] + " ");
                r--;
            }
            System.out.println();
        }
    }
}