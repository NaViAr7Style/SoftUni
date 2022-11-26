package midTerm01ExamPrep;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalCost = 0;

        while (!input.equals("regular") && !input.equals("special")) {
            double currentPrice = Double.parseDouble(input);

            if (currentPrice <= 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }

            totalCost += currentPrice;

            input = scanner.nextLine();
        }

        double taxes = totalCost * 0.2;
        double finalCost = totalCost + taxes;

        if (input.equals("special")) {
            finalCost *= 0.9;
        }

        if (totalCost == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalCost);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", finalCost);
        }
    }
}
