package lecture06BNestedLoopsExercise;

import java.util.Scanner;

public class P02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= secondNum ; i++) {
            int currentNum = i;
            int oddSum = 0;
            int evenSum = 0;

            for (int j = 6; j >= 1; j--) {
                int digit = currentNum % 10;
                currentNum /= 10;

                if (j % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
