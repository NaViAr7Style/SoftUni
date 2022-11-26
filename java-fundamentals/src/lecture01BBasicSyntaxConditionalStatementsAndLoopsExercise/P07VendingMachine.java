package lecture01BBasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalSum = 0;

        while (!input.equals("Start")) {
            double amount = Double.parseDouble(input);
            double threshold = 0.00001;

            if ((Math.abs(amount - 0.1) < threshold)
                    || (Math.abs(amount - 0.2) < threshold)
                    || (Math.abs(amount - 0.5) < threshold)
                    || (Math.abs(amount - 1.0) < threshold)
                    || (Math.abs(amount - 2.0) < threshold)) {
                totalSum += amount;
            } else {
                System.out.printf("Cannot accept %.2f%n", amount);
            }

            input = scanner.nextLine();
        }

        String purchase = scanner.nextLine();

        while (!purchase.equals("End")) {
            switch (purchase) {
                case "Nuts":
                    if (totalSum - 2.00 >= 0) {
                        System.out.printf("Purchased %s%n", purchase);
                        totalSum -= 2.00;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (totalSum - 0.70 >= 0) {
                        System.out.printf("Purchased %s%n", purchase);
                        totalSum -= 0.70;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (totalSum - 1.50 >= 0) {
                        System.out.printf("Purchased %s%n", purchase);
                        totalSum -= 1.50;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (totalSum - 0.80 >= 0) {
                        System.out.printf("Purchased %s%n", purchase);
                        totalSum -= 0.80;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (totalSum - 1.00 >= 0) {
                        System.out.printf("Purchased %s%n", purchase);
                        totalSum -= 1.00;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }

            purchase = scanner.nextLine();
        }

        System.out.printf("Change: %.2f%n", totalSum);
    }
}
