package examPrepApr2022;

import java.util.Scanner;

public class P02DeerOfSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysAway = Integer.parseInt(scanner.nextLine());
        double foodLeft = Integer.parseInt(scanner.nextLine());
        double firstDeerPerDay = Double.parseDouble(scanner.nextLine());
        double secondDeerPerDay = Double.parseDouble(scanner.nextLine());
        double thirdDeerPerDay = Double.parseDouble(scanner.nextLine());

        double totalFoodNeeded = (firstDeerPerDay + secondDeerPerDay + thirdDeerPerDay) * daysAway;

        if (foodLeft >= totalFoodNeeded) {
            System.out.printf("%.0f kilos of food left.%n", Math.floor(foodLeft - totalFoodNeeded));
        } else {
            System.out.printf("%.0f more kilos of food are needed.%n", Math.ceil(totalFoodNeeded - foodLeft));
        }
    }
}
