package lecture02BMultidimensionalArraysExercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        char row = 'a';
        char col = 'a';

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.printf("%c%c%c ", row, col, row);
                col++;
            }

            row++;
            col = row;
            System.out.println();
        }
    }
}