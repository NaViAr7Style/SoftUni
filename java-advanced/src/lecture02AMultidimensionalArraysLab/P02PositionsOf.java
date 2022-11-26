package lecture02AMultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int numToSearch = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNum = matrix[r][c];

                if (currentNum == numToSearch) {
                    output.append(r).append(" ").append(c).append(System.lineSeparator());
                }
            }
        }

        System.out.println(output.isEmpty() ? "not found" : output);
    }
}
