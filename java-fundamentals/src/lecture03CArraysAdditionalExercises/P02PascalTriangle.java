package lecture03CArraysAdditionalExercises;

import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] lastRow = {1};
        System.out.println(lastRow[0]);

        for (int rows = 2; rows <= n; rows++) {
            int[] currentRow = new int[lastRow.length + 1];

            for (int index = 0; index < currentRow.length; index++) {
                if (index == 0 || index == currentRow.length - 1) {
                    currentRow[index] = 1;
                } else {
                    currentRow[index] = lastRow[index - 1] + lastRow[index];
                }
            }

            for (int element : currentRow) {
                System.out.print(element + " ");
            }
            System.out.println();
            lastRow = currentRow;
        }
    }
}
