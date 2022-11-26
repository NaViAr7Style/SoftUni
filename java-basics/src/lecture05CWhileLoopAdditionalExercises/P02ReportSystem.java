package lecture05CWhileLoopAdditionalExercises;

import java.util.Scanner;

public class P02ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int neededMoney = Integer.parseInt(scanner.nextLine());

        int counter = 1;
        int amountCash = 0;
        int trxCash = 0;
        int amountCC = 0;
        int trxCC = 0;
        int collectedMoney = 0;
        boolean isCollected = false;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int productCost = Integer.parseInt(input);

            if (counter % 2 == 1) {
                if (productCost > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    amountCash += productCost;
                    trxCash++;
                    collectedMoney += productCost;
                }
            } else {
                if (productCost < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    amountCC += productCost;
                    trxCC++;
                    collectedMoney += productCost;
                }
            }

            if (collectedMoney >= neededMoney) {
                isCollected = true;
                break;
            }

            counter++;
            input = scanner.nextLine();
        }

        if (isCollected) {
            System.out.printf("Average CS: %.2f%n", amountCash * 1.0 / trxCash);
            System.out.printf("Average CC: %.2f%n", amountCC * 1.0 / trxCC);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
