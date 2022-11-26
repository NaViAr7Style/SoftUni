package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P11HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalDays = Integer.parseInt(scanner.nextLine());
        int hoursPerDay = Integer.parseInt(scanner.nextLine());

        double costPerDay = 0;
        double totalCost = 0;

        for (int i = 1; i <= totalDays; i++) {
            for (int j = 1; j <= hoursPerDay; j++) {
                double price = 0;
                if (i % 2 == 0 && j % 2 == 1) {
                    price = 2.50;
                } else if (i % 2 == 1 && j % 2 == 0) {
                    price = 1.25;
                } else {
                    price = 1.00;
                }

                costPerDay += price;
            }

            totalCost += costPerDay;
            System.out.printf("Day: %d - %.2f leva%n", i, costPerDay);
            costPerDay = 0;
        }

        System.out.printf("Total: %.2f leva%n", totalCost);
    }
}
