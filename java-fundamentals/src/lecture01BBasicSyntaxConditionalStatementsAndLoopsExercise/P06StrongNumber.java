package lecture01BBasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialNum = Integer.parseInt(scanner.nextLine());

        int num = initialNum;
        int sum = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            int factorial = 1;

            for (int i = lastDigit; i >= 2; i--) {
                factorial *= i;
            }

            sum += factorial;
            num /= 10;
        }

        if (sum == initialNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
