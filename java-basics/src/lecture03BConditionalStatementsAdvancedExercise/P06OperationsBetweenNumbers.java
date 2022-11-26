package lecture03BConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        //char operator = scanner.next().charAt(0);
        String operator = scanner.nextLine();

        double result = switch (operator) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            default -> 0;
        };

        switch (operator) {
            case "+":
            case "-":
            case "*":
                if (result % 2 == 0) {
                    System.out.printf("%d %s %d = %.0f - even%n", n1, operator, n2, result);
                } else {
                    System.out.printf("%d %s %d = %.0f - odd%n", n1, operator, n2, result);
                }
                break;
            case "/":
                if (n2 == 0) {
                    System.out.printf("Cannot divide %d by zero%n", n1);
                } else {
                    result = n1 * 1.0 / n2;
                    System.out.printf("%d %s %d = %.2f%n", n1, operator, n2, result);
                }
                break;
            case "%":
                if (n2 == 0) {
                    System.out.printf("Cannot divide %d by zero%n", n1);
                } else {
                    result = n1 % n2;
                    System.out.printf("%d %s %d = %.0f%n", n1, operator, n2, result);
                }
                break;
        }
    }
}
