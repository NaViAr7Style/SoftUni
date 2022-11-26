package lecture02BMultidimensionalArraysExercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);

        if (pattern == 'A') {
            createAndPrintMatrixPatternA(n);
        } else if (pattern == 'B') {
            createAndPrintMatrixPatternB(n);
        }
    }

    private static void createAndPrintMatrixPatternB(int a) {
        int[][] matrix = new int[a][a];
        int counter = 1;

        for (int col = 0; col < matrix[0].length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }

        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void createAndPrintMatrixPatternA(int a) {
        int[][] matrix = new int[a][a];
        int counter = 1;

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }

        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}