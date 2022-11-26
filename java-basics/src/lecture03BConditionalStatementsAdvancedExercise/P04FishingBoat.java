package lecture03BConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());

        double boatRent = 0;

        switch (season) {
            case "Spring":
                 if (fishermen <= 6) {
                     boatRent = 3000 * 0.9;
                 } else if (fishermen <= 11) {
                     boatRent = 3000 * 0.85;
                 } else {
                     boatRent = 3000 * 0.75;
                 }
                 if (fishermen % 2 == 0) {
                     boatRent *= 0.95;
                 }
                break;
            case "Summer":
                if (fishermen <= 6) {
                    boatRent = 4200 * 0.9;
                } else if (fishermen <= 11) {
                    boatRent = 4200 * 0.85;
                } else {
                    boatRent = 4200 * 0.75;
                }
                if (fishermen % 2 == 0) {
                    boatRent *= 0.95;
                }
                break;
            case "Autumn":
                if (fishermen <= 6) {
                    boatRent = 4200 * 0.9;
                } else if (fishermen <= 11) {
                    boatRent = 4200 * 0.85;
                } else {
                    boatRent = 4200 * 0.75;
                }
                break;
            case "Winter":
                if (fishermen <= 6) {
                    boatRent = 2600 * 0.9;
                } else if (fishermen <= 11) {
                    boatRent = 2600 * 0.85;
                } else {
                    boatRent = 2600 * 0.75;
                }
                if (fishermen % 2 == 0) {
                    boatRent *= 0.95;
                }
                break;
        }

        if (budget >= boatRent) {
            System.out.printf("Yes! You have %.2f leva left.%n", budget - boatRent);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.%n", boatRent - budget);
        }
    }
}
