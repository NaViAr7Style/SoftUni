package lecture02BMultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P12TheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        char newColor = scanner.nextLine().charAt(0);

        int[] clickedPixels = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int clickedRow = clickedPixels[0];
        int clickedCol = clickedPixels[1];

        char oldColor = matrix[clickedRow][clickedCol];

        paint(matrix, newColor, oldColor, clickedRow, clickedCol);
        print(matrix);
    }

    private static void print(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(row);
        }
    }

    private static void paint(char[][] matrix, char newColor, char oldColor, int clickedRow, int clickedCol) {
        if (isOutOfBounds(matrix, clickedRow, clickedCol) || matrix[clickedRow][clickedCol] != oldColor) {
            return;
        }

        matrix[clickedRow][clickedCol] = newColor;

        paint(matrix, newColor, oldColor, clickedRow - 1, clickedCol);
        paint(matrix, newColor, oldColor, clickedRow + 1, clickedCol);
        paint(matrix, newColor, oldColor, clickedRow, clickedCol + 1);
        paint(matrix, newColor, oldColor, clickedRow, clickedCol - 1);
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}