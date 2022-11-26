package lecture01BBasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int orders = Integer.parseInt(scanner.nextLine());
        double totalSum = 0;

        for (int i = 1; i <= orders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());

            double orderCost = pricePerCapsule * days * capsuleCount;
            System.out.printf("The price for the coffee is: $%.2f%n", orderCost);
            totalSum += orderCost;
        }

        System.out.printf("Total: $%.2f%n", totalSum);
    }
}
