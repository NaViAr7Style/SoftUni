package examJuly2019;

import java.util.Scanner;

public class P02FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double pricePerNight = Double.parseDouble(scanner.nextLine());
        int miscellaneous = Integer.parseInt(scanner.nextLine());

        if (nights > 7) {
            pricePerNight *= 0.95;
        }

        double housingExpenses = nights * pricePerNight;
        double additionalExpenses = miscellaneous * 0.01 * budget;

        double leftover = budget - housingExpenses - additionalExpenses;

        if (leftover >= 0) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.%n", leftover);
        } else {
            System.out.printf("%.2f leva needed.%n", -leftover);
        }
    }
}
