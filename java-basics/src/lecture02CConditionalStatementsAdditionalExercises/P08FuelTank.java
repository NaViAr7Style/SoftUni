package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P08FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelLeft = Double.parseDouble(scanner.nextLine());

        switch (fuelType) {
            case "Diesel":
            case "Gasoline":
            case "Gas":
                if (fuelLeft >= 25) {
                    System.out.printf("You have enough %s.%n", fuelType.toLowerCase());
                } else {
                    System.out.printf("Fill your tank with %s!%n", fuelType.toLowerCase());
                }
                break;
            default:
                System.out.println("Invalid fuel!");
        }
    }
}
