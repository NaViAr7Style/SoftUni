package lecture05AWhileLoopLab;

import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalAmount = 0;

        while (!input.equals("NoMoreMoney")) {
            double amount = Double.parseDouble(input);

            if (amount < 0) {
                System.out.println("Invalid operation!");
                break;
            }

            System.out.printf("Increase: %.2f%n", amount);
            totalAmount += amount;

            input = scanner.nextLine();
        }

        System.out.printf("Total: %.2f%n", totalAmount);
    }
}
