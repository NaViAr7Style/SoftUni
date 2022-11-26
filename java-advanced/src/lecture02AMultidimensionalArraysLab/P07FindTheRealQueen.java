package lecture02AMultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];

        for (int r = 0; r < chessboard.length; r++) {
            String[] input = scanner.nextLine().split(" ");

            for (int c = 0; c < chessboard[r].length; c++) {
                chessboard[r][c] = input[c].charAt(0);
            }
        }

        List<Integer> rowsToSkip = new ArrayList<>();
        List<Integer> colsToSkip = new ArrayList<>();

        List<String> possibleQueens = new ArrayList<>();

        for (int r = 0; r < chessboard.length; r++) {
            if (rowsToSkip.contains(r)) {
                continue;
            }

            for (int c = 0; c < chessboard[r].length; c++) {
                if (rowsToSkip.contains(r)) {
                    break;
                }
                if (colsToSkip.contains(c)) {
                    continue;
                }

                if (chessboard[r][c] == 'q') {
                    if (repeatedInRow(chessboard, r, c)) {
                        rowsToSkip.add(r);
                        continue;
                    }

                    if (repeatedInColumn(chessboard, r, c)) {
                        colsToSkip.add(c);
                        continue;
                    }

                    if (!repeatedInDiagonals(chessboard, r, c)) {
                        possibleQueens.add(r + " " + c);
                    }
                }
            }
        }

        while (possibleQueens.size() > 1) {
            int row = Integer.parseInt(possibleQueens.get(0).split(" ")[0]);
            int col = Integer.parseInt(possibleQueens.get(0).split(" ")[1]);

            if (rowsToSkip.contains(row) || colsToSkip.contains(col)) {
                possibleQueens.remove(0);
            } else {
                break;
            }
        }

        System.out.println(possibleQueens.get(0));
    }

    private static boolean repeatedInDiagonals(char[][] matrix, int r, int c) {
        boolean isAttacked = false;
        int row = 0;
        int col = 0;

        if (r >= c) {
            row = r - c;
        } else {
            col = c - r;
        }



        while (isIndexInBounds(matrix, row, col)) {
            if (row == r && col == c) {
                row++;
                col++;
                continue;
            }
            if (matrix[row][col] == 'q') {
                isAttacked = true;
                break;
            }

            row++;
            col++;
        }

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[r].length; cols++) {
                if (rows == r && cols == c) {
                    continue;
                }

                if (rows + cols == r + c && matrix[rows][cols] == 'q') {
                    isAttacked = true;
                    break;
                }
            }
            if (isAttacked) {
                break;
            }
        }

        return isAttacked;
    }

    private static boolean isIndexInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static boolean repeatedInColumn(char[][] matrix, int r, int c) {
        boolean isAttacked = false;

        for (int row = 0; row < matrix.length; row++) {
            if (row == r) {
                continue;
            }

            if (matrix[row][c] == 'q') {
                isAttacked = true;
                break;
            }
        }

        return isAttacked;
    }

    private static boolean repeatedInRow(char[][] matrix, int r, int c) {
        boolean isAttacked = false;

        for (int col = 0; col < matrix[r].length; col++) {
            if (col == c) {
                continue;
            }

            if (matrix[r][col] == 'q') {
                isAttacked = true;
                break;
            }
        }

        return isAttacked;
    }
}
