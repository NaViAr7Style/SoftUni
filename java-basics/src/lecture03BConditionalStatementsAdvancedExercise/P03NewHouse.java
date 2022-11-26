package lecture03BConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int flowerCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double finalCost = 0;

        switch (flowerType) {
            case "Roses":
                if (flowerCount > 80) {
                    finalCost = flowerCount * 5 * 0.9;
                } else {
                    finalCost = flowerCount * 5;
                }
                break;
            case "Dahlias":
                if (flowerCount > 90) {
                    finalCost = flowerCount * 3.80 * 0.85;
                } else {
                    finalCost = flowerCount * 3.80;
                }
                break;
            case "Tulips":
                if (flowerCount > 80) {
                    finalCost = flowerCount * 2.80 * 0.85;
                } else {
                    finalCost = flowerCount * 2.80;
                }
                break;
            case "Narcissus":
                if (flowerCount < 120) {
                    finalCost = flowerCount * 3 * 1.15;
                } else {
                    finalCost = flowerCount * 3;
                }
                break;
            case "Gladiolus":
                if (flowerCount < 80) {
                    finalCost = flowerCount * 2.50 * 1.2;
                } else {
                    finalCost = flowerCount * 2.50;
                }
                break;
        }

        if (finalCost <= budget) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.%n", flowerCount, flowerType, budget - finalCost);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.%n", finalCost - budget);
        }
    }
}
