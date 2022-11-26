package lecture10BExamPreparationExercise;

import java.util.Scanner;

public class P02Bee {

    public static int beeRow;
    public static int beeCol;
    public static int pollinatedFlowers;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[dimension][dimension];

        for (int r = 0; r < dimension; r++) {
            String input = scanner.nextLine();
            territory[r] = input.toCharArray();

            if (input.contains("B")) {
                beeRow = r;
                beeCol = input.indexOf("B");
            }
        }

        boolean isLost = false;
        pollinatedFlowers = 0;

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            territory[beeRow][beeCol] = '.';

            switch (command) {
                case "up":
                    if (isOutOfBounds(territory, -1, 0)) {
                        isLost = true;
                        break;
                    }
                    moveBee(territory, -1, 0);
                    break;
                case "down":
                    if (isOutOfBounds(territory, 1, 0)) {
                        isLost = true;
                        break;
                    }
                    moveBee(territory, 1, 0);
                    break;
                case "left":
                    if (isOutOfBounds(territory, 0, -1)) {
                        isLost = true;
                        break;
                    }
                    moveBee(territory, 0, -1);
                    break;
                case "right":
                    if (isOutOfBounds(territory, 0, 1)) {
                        isLost = true;
                        break;
                    }
                    moveBee(territory, 0, 1);
                    break;
            }

            if (isLost) {
                break;
            }
            command = scanner.nextLine();
        }

        if (isLost) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }

        print(territory);
    }

    private static void moveBee(char[][] matrix, int rowMutator, int colMutator) {
        int moveRow = beeRow + rowMutator;
        int moveCol = beeCol + colMutator;

        if (matrix[moveRow][moveCol] == 'f') {
            pollinatedFlowers++;
        }

        if (matrix[moveRow][moveCol] == 'O') {
            matrix[moveRow][moveCol] = '.';
            beeRow = moveRow;
            beeCol = moveCol;
            moveBee(matrix, rowMutator, colMutator);
            return;
        }

        matrix[moveRow][moveCol] = 'B';
        beeRow = moveRow;
        beeCol = moveCol;
    }

    private static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int rowMutator, int colMutator) {
        int row = beeRow + rowMutator;
        int col = beeCol + colMutator;

        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}