package lecture02BMultidimensionalArraysExercise;

import java.util.*;

public class P07Crossfire {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = numArray[0];
        int cols = numArray[1];

        int[][] matrix = new int[rows][cols];

        int counter = 1;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = counter;
                counter++;
            }
        }

        String input = scanner.nextLine();

        Map<Integer, List<Integer>> collateral = new HashMap<>();

        while (!input.equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int rowIndex = tokens[0];
            int colIndex = tokens[1];
            int radius = tokens[2];

            getCollateral(matrix, rowIndex, colIndex, radius, collateral);

            matrix = updateMatrix(matrix, collateral);
            matrix = deleteEmptyRows(matrix);

            collateral.clear();

            input = scanner.nextLine();
        }

        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] updateMatrix(int[][] matrix, Map<Integer, List<Integer>> collateral) {
        int[][] updatedMatrix = new int[matrix.length][];

        for (int r = 0, matrixRow = 0; r < updatedMatrix.length; r++, matrixRow++) {

            if (matrixRow >= matrix.length) {
                break;
            }

            int rowSize = matrix[matrixRow].length;
            int destroyedCells = 0;

            if (collateral.containsKey(matrixRow)) {
                destroyedCells = collateral.get(matrixRow).size();
            }

            while (rowSize - destroyedCells <= 0 && matrixRow + 1 < matrix.length) {
                matrixRow++;
                rowSize = matrix[matrixRow].length;
                destroyedCells = 0;

                if (collateral.containsKey(matrixRow)) {
                    destroyedCells = collateral.get(matrixRow).size();
                }
            }

            if (rowSize - destroyedCells <= 0) {
                break;
            }

            updatedMatrix[r] = new int[rowSize - destroyedCells];

            for (int c = 0, matrixColumn = 0; c < updatedMatrix[r].length; c++, matrixColumn++) {

                while (collateral.containsKey(matrixRow) && collateral.get(matrixRow).contains(matrixColumn)) {
                    matrixColumn++;
                }

                updatedMatrix[r][c] = matrix[matrixRow][matrixColumn];
            }
        }

        return updatedMatrix;
    }


    private static int[][] deleteEmptyRows(int[][] matrix) {
        int remainingRows = 0;

        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r] == null) {
                break;
            }

            remainingRows++;
        }

        int[][] finalMatrix = new int[remainingRows][];

        for (int r = 0; r < finalMatrix.length; r++) {
            finalMatrix[r] = new int[matrix[r].length];

            for (int c = 0; c < finalMatrix[r].length; c++) {
                finalMatrix[r][c] = matrix[r][c];
            }
        }

        return finalMatrix;
    }

    private static boolean isValidIndex(int[][] matrix, int rowIndex, int colIndex) {
        return rowIndex >= 0 && rowIndex < matrix.length && colIndex >= 0 && colIndex < matrix[rowIndex].length;
    }

    private static void getCollateral(int[][] matrix, int rowIndex, int colIndex, int radius, Map<Integer, List<Integer>> collateral) {

        for (int r = rowIndex - radius; r <= rowIndex + radius; r++) {
            if (r == rowIndex) {
                continue;
            }

            if (isValidIndex(matrix, r, colIndex)) {
                collateral.putIfAbsent(r, new ArrayList<>());
                collateral.get(r).add(colIndex);
            }
        }

        for (int c = colIndex - radius; c <= colIndex + radius; c++) {
            if (isValidIndex(matrix, rowIndex, c)) {
                collateral.putIfAbsent(rowIndex, new ArrayList<>());
                collateral.get(rowIndex).add(c);
            }
        }
    }
}