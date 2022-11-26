package lecture03CConditionalStatementsAdvancedAdditionalExercises;

import java.util.Scanner;

public class P03Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemumsCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int tulipsCount = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;

        switch (season) {
            case "Spring":
            case "Summer":
                chrysanthemumsPrice = 2;
                rosesPrice = 4.1;
                tulipsPrice = 2.5;
                break;
            case "Autumn":
            case "Winter":
                chrysanthemumsPrice = 3.75;
                rosesPrice = 4.5;
                tulipsPrice = 4.15;
                break;
        }

        double bouquetCost = chrysanthemumsCount * chrysanthemumsPrice + rosesCount * rosesPrice + tulipsCount * tulipsPrice;

        if (holiday.equals("Y")) {
            bouquetCost *= 1.15;
        }
        if (tulipsCount > 7 && season.equals("Spring")) {
            bouquetCost *= 0.95;
        }
        if (rosesCount >= 10 && season.equals("Winter")) {
            bouquetCost *= 0.9;
        }
        if (chrysanthemumsCount + rosesCount + tulipsCount > 20) {
            bouquetCost *= 0.8;
        }

        bouquetCost += 2;
        System.out.printf("%.2f%n", bouquetCost);
    }
}
