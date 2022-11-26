package lecture01CFirstStepsInCodingAdditionalExercises;

import java.util.Scanner;

public class P04VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vegetablePrice = Double.parseDouble(scanner.nextLine());
        double fruitPrice = Double.parseDouble(scanner.nextLine());
        int soldVegetables = Integer.parseInt(scanner.nextLine());
        int soldFruits = Integer.parseInt(scanner.nextLine());

        double incomeLv = vegetablePrice * soldVegetables + fruitPrice * soldFruits;
        double incomeEuro = incomeLv / 1.94;

        System.out.printf("%.2f%n", incomeEuro);
    }
}
