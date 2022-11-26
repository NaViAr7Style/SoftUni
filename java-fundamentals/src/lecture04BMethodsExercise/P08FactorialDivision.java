package lecture04BMethodsExercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double finalResult = factorial(firstNum) / factorial(secondNum);

        System.out.printf("%.2f", finalResult);
    }

    public static double factorial(int a) {
        double result = 1;

        for (int i = a; i >= 1; i--) {
            result *= i;
        }

        return result;
    }
}
