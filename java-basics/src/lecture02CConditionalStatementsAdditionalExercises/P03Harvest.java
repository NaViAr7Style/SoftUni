package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P03Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int area = Integer.parseInt(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());
        int litres = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double finalWeight = area * 0.4 * weight;
        double totalLitres = finalWeight / 2.5;

        if (totalLitres < litres) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.%n", Math.floor(litres - totalLitres));
        } else {
            double litresLeft= totalLitres - litres;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", totalLitres);
            System.out.printf("%.0f liters left -> %.0f liters per person.%n", Math.floor(litresLeft), Math.ceil(litresLeft / workers));
        }
    }
}
