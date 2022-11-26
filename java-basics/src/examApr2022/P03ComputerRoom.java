package examApr2022;

import java.util.Scanner;

public class P03ComputerRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int hoursSpent = Integer.parseInt(scanner.nextLine());
        int headcount = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double pricePerHour = switch (month) {
            case "march", "april", "may" -> switch (timeOfDay) {
                case "day" -> 10.50;
                case "night" -> 8.40;
                default -> 0;
            };
            case "june", "july", "august" -> switch (timeOfDay) {
                case "day" -> 12.60;
                case "night" -> 10.20;
                default -> 0;
            };
            default -> 0;
        };

        if (headcount >= 4) {
            pricePerHour *= 0.9;
        }

        if (hoursSpent >= 5) {
            pricePerHour *= 0.5;
        }

        System.out.printf("Price per person for one hour: %.2f%n", pricePerHour);
        System.out.printf("Total cost of the visit: %.2f%n", pricePerHour * hoursSpent * headcount);
    }
}
