package lecture02AMultidimensionalArraysLab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int r = 0; r < firstMatrix.length; r++) {
            String[] input = scanner.nextLine().split(" ");

            for (int c = 0; c < firstMatrix[r].length; c++) {
                firstMatrix[r][c] = input[c].charAt(0);
            }
        }

        for (int r = 0; r < secondMatrix.length; r++) {
            String[] input = scanner.nextLine().split(" ");

            for (int c = 0; c < secondMatrix[r].length; c++) {
                secondMatrix[r][c] = input[c].charAt(0);
            }
        }

        char[][] intersectionMatrix = new char[rows][cols];

        for (int r = 0; r < intersectionMatrix.length; r++) {
            for (int c = 0; c < intersectionMatrix[r].length; c++) {
                if (firstMatrix[r][c] == secondMatrix[r][c]) {
                    intersectionMatrix[r][c] = firstMatrix[r][c];
                } else {
                    intersectionMatrix[r][c] = '*';
                }
            }
        }

        for (char[] arr : intersectionMatrix) {
            for (char symbol : arr){
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
