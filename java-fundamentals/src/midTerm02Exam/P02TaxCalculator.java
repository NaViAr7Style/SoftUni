package midTerm02Exam;

import java.util.Scanner;

public class P02TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicles = scanner.nextLine().split(">>");
        double totalTaxes = 0;

        for (int i = 0; i < vehicles.length; i++) {
            String[] currentVehicle = vehicles[i].split(" ");
            String carType = currentVehicle[0];
            int yearsInUse = Integer.parseInt(currentVehicle[1]);
            int kilometersTraveled = Integer.parseInt(currentVehicle[2]);
            double finalTax;

            switch (carType) {
                case "family":
                    finalTax = 50;
                    finalTax -= yearsInUse * 5;
                    finalTax += Math.floor(kilometersTraveled / 3000.0) * 12;
                    break;
                case "heavyDuty":
                    finalTax = 80;
                    finalTax -= yearsInUse * 8;
                    finalTax += Math.floor(kilometersTraveled / 9000.0) * 14;
                    break;
                case "sports":
                    finalTax = 100;
                    finalTax -= yearsInUse * 9;
                    finalTax += Math.floor(kilometersTraveled / 2000.0) * 18;
                    break;
                default:
                    System.out.println("Invalid car type.");
                    continue;
            }

            totalTaxes += finalTax;

            System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, finalTax);
        }

        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n", totalTaxes);
    }
}
