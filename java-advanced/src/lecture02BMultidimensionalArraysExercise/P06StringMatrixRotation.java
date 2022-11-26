package lecture02BMultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotationDegrees = Integer.parseInt(scanner.nextLine().split("[()]")[1]);
        rotationDegrees %= 360;
        String input = scanner.nextLine();

        int longestWord = 0;
        List<String> wordList = new ArrayList<>();

        while (!input.equals("END")) {
            wordList.add(input);

            if (input.length() > longestWord) {
                longestWord = input.length();
            }

            input = scanner.nextLine();
        }

        int rows = wordList.size();
        int cols = longestWord;

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < wordList.size(); r++) {
            String currentWord = wordList.get(r);

            for (int c = 0; c < matrix[0].length; c++) {
                if (c < currentWord.length()) {
                    char symbol = currentWord.charAt(c);
                    matrix[r][c] = symbol;
                } else {
                    matrix[r][c] = ' ';
                }
            }

        }

        rotateAndPrintMatrix(matrix, rotationDegrees);
    }

    private static void rotateAndPrintMatrix(char[][] matrix, int degrees) {
        switch (degrees) {
            case 0:
                for (int r = 0; r < matrix.length; r++) {
                    for (int c = 0; c < matrix[r].length; c++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int c = 0; c < matrix[0].length; c++) {
                    for (int r = matrix.length - 1; r >= 0; r--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int r = matrix.length - 1; r >= 0; r--) {
                    for (int c = matrix[r].length - 1; c >= 0; c--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }

                break;
            case 270:
                for (int c = matrix[0].length - 1; c >= 0; c--) {
                    for (int r = 0; r < matrix.length; r++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
