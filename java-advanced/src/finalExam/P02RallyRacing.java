package finalExam;

import java.util.Scanner;

public class P02RallyRacing {

    public static int carRow;
    public static int carCol;
    public static boolean isFinished;
    public static int distanceCovered;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        String carName = scanner.nextLine();

        char[][] matrix = new char[dimensions][dimensions];

        for (int r = 0; r < matrix.length; r++) {
            String[] currentRow = scanner.nextLine().split(" ");

            for (int c = 0; c < currentRow.length; c++) {
                matrix[r][c] = currentRow[c].charAt(0);
            }
        }

        String direction = scanner.nextLine();

        while (!direction.equals("End") && !isFinished) {

            switch (direction) {
                case "up":
                    moveCar(matrix, -1, 0);
                    break;
                case "down":
                    moveCar(matrix, 1, 0);
                    break;
                case "left":
                    moveCar(matrix, 0, -1);
                    break;
                case "right":
                    moveCar(matrix, 0, 1);
                    break;
            }

            direction = scanner.nextLine();
        }

        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", carName);
        } else {
            System.out.printf("Racing car %s DNF.%n", carName);
        }

        System.out.printf("Distance covered %d km.%n", distanceCovered);

        matrix[carRow][carCol] = 'C';
        print(matrix);
    }

    private static void moveCar(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = carRow + rowMutator;
        int nextCol = carCol + colMutator;
        distanceCovered += 10;

        if (matrix[nextRow][nextCol] == '.') {
            carRow = nextRow;
            carCol = nextCol;
        } else if (matrix[nextRow][nextCol] == 'F') {
            carRow = nextRow;
            carCol = nextCol;
            isFinished = true;
        } else if (matrix[nextRow][nextCol] == 'T') {
            distanceCovered += 20;
            matrix[nextRow][nextCol] = '.';
            findTunnelExit(matrix);
        }
    }

    private static void findTunnelExit(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            boolean isFound = false;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'T') {
                    carRow = r;
                    carCol = c;
                    matrix[r][c] = '.';
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                break;
            }
        }
    }

    private static void print(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}