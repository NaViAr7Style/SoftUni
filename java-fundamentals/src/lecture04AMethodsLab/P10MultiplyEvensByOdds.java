package lecture04AMethodsLab;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNum = Integer.parseInt(scanner.nextLine());

        int result = evensByOddsMultiplied(inputNum);

        System.out.println(result);
    }

    public static int evensByOddsMultiplied(int number) {
        int evenSum = 0;
        int oddSum = 0;
        int absolute = Math.abs(number);

        while (absolute > 0) {
            int currentDigit = absolute % 10;
            if (currentDigit % 2 == 0) {
                evenSum += currentDigit;
            } else {
                oddSum += currentDigit;
            }
            absolute /= 10;
        }

        return evenSum * oddSum;
    }
}
