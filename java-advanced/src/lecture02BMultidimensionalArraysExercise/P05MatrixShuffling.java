package lecture02BMultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split(" ");
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(" ");

            if (tokens.length != 5 || !tokens[0].equals("swap")) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            int r1 = Integer.parseInt(tokens[1]);
            int c1 = Integer.parseInt(tokens[2]);
            int r2 = Integer.parseInt(tokens[3]);
            int c2 = Integer.parseInt(tokens[4]);

            if (!isInBounds(matrix, r1, c1, r2, c2)) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String temp = matrix[r1][c1];
            matrix[r1][c1] = matrix[r2][c2];
            matrix[r2][c2] = temp;

            for (String[] arr : matrix) {
                for (String element : arr) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isInBounds(String[][] matrix, int r1, int c1, int r2, int c2) {
        return r1 >= 0 && r1 < matrix.length && c1 >= 0 && c1 < matrix[r1].length &&
                r2 >= 0 && r2 < matrix.length && c2 >= 0 && c2 < matrix[r2].length;
    }
}
