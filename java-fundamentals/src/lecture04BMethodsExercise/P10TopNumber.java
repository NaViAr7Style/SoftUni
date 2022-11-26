package lecture04BMethodsExercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        topNumbers(n);
    }

    public static void topNumbers(int a) {
        for (int i = 1; i <= a; i++) {
            int sum = 0;
            boolean hasOddDigit = false;
            int currentNum = i;

            while (currentNum > 0) {
                int currentDigit = currentNum % 10;
                if (currentDigit % 2 == 1) {
                    hasOddDigit = true;
                }
                sum += currentDigit;
                currentNum /= 10;
            }

            if (sum % 8 == 0 && hasOddDigit) {
                System.out.println(i);
            }
        }
    }
}
