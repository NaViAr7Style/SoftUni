package lecture06BNestedLoopsExercise;

import java.util.Scanner;

public class P03SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sumPrime = 0;
        int sumNonPrime = 0;

        while (!input.equals("stop")) {
            int number = Integer.parseInt(input);

            if (number < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }

            boolean isNonPrime = false;
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isNonPrime = true;
                    break;
                }
            }

            if (isNonPrime) {
                sumNonPrime += number;
            } else {
                sumPrime += number;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d%n", sumNonPrime);
    }
}
