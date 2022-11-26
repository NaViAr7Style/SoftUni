package lecture03BArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (i % 2 == 0) {
                firstArr[i] = input[0];
                secondArr[i] = input[1];
            } else {
                firstArr[i] = input[1];
                secondArr[i] = input[0];
            }
        }

        for (int element : firstArr) {
            System.out.print(element + " ");
        }
        System.out.println();

        for (int element : secondArr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
