package lecture04AMethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int secondNum = Integer.parseInt(scanner.nextLine());

        double result = mathOperations(firstNum, operator, secondNum);

        DecimalFormat df = new DecimalFormat("0.##");

        System.out.println(df.format(result));
    }

    public static double mathOperations(int a, char operator, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '*':
                return a * b;
            case '-':
                return a - b;
            case '/':
                if (b != 0) {
                    return a * 1.0 / b;
                } else {
                    return 0;
                }
        }
        return 0;
    }
}
