package lecture01CFirstStepsInCodingAdditionalExercises;

import java.util.Scanner;

public class P06Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mackerelPrice = Double.parseDouble(scanner.nextLine());
        double spratPrice = Double.parseDouble(scanner.nextLine());
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        double scadKg = Double.parseDouble(scanner.nextLine());
        int clamsKg = Integer.parseInt(scanner.nextLine());

        double bonitoCost = mackerelPrice * 1.6 * bonitoKg;
        double scadCost = spratPrice * 1.8 * scadKg;
        double clamsCost = clamsKg * 7.5;

        double allExpenses = bonitoCost + scadCost + clamsCost;

        System.out.printf("%.2f%n", allExpenses);
    }
}
