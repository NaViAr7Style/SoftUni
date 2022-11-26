package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P09FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelPumped = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();
        double finalCost = 0;

        switch (fuelType) {
            case "Gasoline":
                switch (clubCard) {
                    case "Yes":
                        finalCost = fuelPumped * 2.04;
                        break;
                    case "No":
                        finalCost = fuelPumped * 2.22;
                        break;
                }
                break;
            case "Diesel":
                switch (clubCard) {
                    case "Yes":
                        finalCost = fuelPumped * 2.21;
                        break;
                    case "No":
                        finalCost = fuelPumped * 2.33;
                        break;
                }
                break;
            case "Gas":
                switch (clubCard) {
                    case "Yes":
                        finalCost = fuelPumped * 0.85;
                        break;
                    case "No":
                        finalCost = fuelPumped * 0.93;
                        break;
                }
                break;
        }

        if (fuelPumped > 25) {
            finalCost *= 0.9;
        } else if (fuelPumped >= 20) {
            finalCost *= 0.92;
        }

        System.out.printf("%.2f lv.%n", finalCost);
    }
}
