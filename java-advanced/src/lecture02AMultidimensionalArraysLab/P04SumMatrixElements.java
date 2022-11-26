package lecture02AMultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        int sum = 0;

        for (int[] arr : matrix) {
            for (int num : arr) {
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
