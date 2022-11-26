package lecture02AMultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionsFirst = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int arraysCountFirst = dimensionsFirst[0];
        int sizeOfArrayFirst = dimensionsFirst[1];

        int[][] firstMatrix = new int[arraysCountFirst][sizeOfArrayFirst];

        for (int i = 0; i < arraysCountFirst; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            firstMatrix[i] = arr;
        }

        int[] dimensionsSecond = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int arraysCountSecond = dimensionsSecond[0];
        int sizeOfArraySecond = dimensionsSecond[1];

        int[][] secondMatrix = new int[arraysCountSecond][sizeOfArraySecond];

        for (int i = 0; i < arraysCountSecond; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            secondMatrix[i] = arr;
        }

        if (compareMatrices(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int r = 0; r < firstMatrix.length; r++) {
            if (firstMatrix[r].length != secondMatrix[r].length) {
                return false;
            }
            for (int c = 0; c < firstMatrix[r].length; c++) {
                if (firstMatrix[r][c] != secondMatrix[r][c]) {
                    return false;
                }
            }

        }

        return true;
    }
}