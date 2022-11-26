package lecture03CArraysAdditionalExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] encryptedInput = new int[n];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int numericalValue = 0;

            for (int j = 0; j < input.length(); j++) {
                char symbol = input.charAt(j);

                switch (symbol) {
                    case 'a':
                    case 'A':
                    case 'e':
                    case 'E':
                    case 'i':
                    case 'I':
                    case 'o':
                    case 'O':
                    case 'u':
                    case 'U':
                        numericalValue += symbol * input.length();
                        break;
                    default: numericalValue += symbol / input.length();
                }
            }

            encryptedInput[i] = numericalValue;
        }

        Arrays.sort(encryptedInput);

        for (int element : encryptedInput) {
            System.out.println(element);
        }
    }
}
