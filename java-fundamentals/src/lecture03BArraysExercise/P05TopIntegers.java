package lecture03BArraysExercise;

import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] intArray = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            intArray[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < intArray.length; i++) {
            boolean isTopInteger = true;

            for (int j = i + 1; j < intArray.length; j++) {

                if (intArray[i] <= intArray[j]) {
                    isTopInteger = false;
                    break;
                }
            }

            if (isTopInteger || i == intArray.length - 1) {
                System.out.print(intArray[i] + " ");
            }
        }

        System.out.println();
    }
}
