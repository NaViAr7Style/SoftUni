package lecture03BArraysExercise;

import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rotations; i++) {
            String firstElement = input[0];

            System.arraycopy(input, 1, input, 0, input.length - 1);

            input[input.length - 1] = firstElement;
        }

        for (String element : input) {
            System.out.print(element + " ");
        }
    }
}
