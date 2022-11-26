package lecture02CDataTypesAndVariablesAdditionalExercises;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] inputSplit = input.split(" ");

            long left = Long.parseLong(inputSplit[0]);
            long right = Long.parseLong(inputSplit[1]);
            long sum = 0;

            if (Long.compare(left, right) > 0) {
                sum = sumOfDigits(left);
            } else {
                sum = sumOfDigits(right);
            }

            System.out.println(sum);
        }
    }

    public static long sumOfDigits(long a) {
        long sum = 0;
        long currentNum = Math.abs(a);
        while (Long.compare(currentNum, 0) != 0) {
            long currentDigit = currentNum % 10;
            sum += currentDigit;
            currentNum /= 10;
        }

        return sum;
    }
}