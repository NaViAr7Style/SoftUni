package lecture01CBasicSyntaxConditionalStatementsAndLoopsAdditionalExercises;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double budgetLeft = budget;

        boolean isOutOfMoney = false;
        String input = scanner.nextLine();

        while (!input.equals("Game Time")) {
            double gamePrice = 0;
            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                default:
                    System.out.println("Not Found");
            }

            if (budgetLeft - gamePrice >= 0 && gamePrice != 0) {
                System.out.printf("Bought %s%n", input);
                budgetLeft -= gamePrice;
            } else if (gamePrice != 0) {
                System.out.println("Too Expensive");
            }
            if (budgetLeft < 0.00001) {
                System.out.println("Out of money!");
                isOutOfMoney = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (!isOutOfMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f%n", budget - budgetLeft, budgetLeft);
        }
    }
}
