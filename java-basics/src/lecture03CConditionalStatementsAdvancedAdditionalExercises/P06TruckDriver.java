package lecture03CConditionalStatementsAdvancedAdditionalExercises;

import java.util.Scanner;

public class P06TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kilometersPerMonth = Double.parseDouble(scanner.nextLine());

        double pricePerKilometer = 0;

        if (kilometersPerMonth <= 5000) {
            pricePerKilometer = switch (season) {
                case "Spring", "Autumn" -> 0.75;
                case "Summer" -> 0.9;
                case "Winter" -> 1.05;
                default -> pricePerKilometer;
            };
        } else if (kilometersPerMonth <= 10000) {
            pricePerKilometer = switch (season) {
                case "Spring", "Autumn" -> 0.95;
                case "Summer" -> 1.1;
                case "Winter" -> 1.25;
                default -> pricePerKilometer;
            };
        } else {
            pricePerKilometer = 1.45;
        }

        double salary = pricePerKilometer * kilometersPerMonth * 4 * 0.9;
        System.out.printf("%.2f%n", salary);
    }
}
