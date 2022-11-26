package examPrepApr2022;

import java.util.Scanner;

public class P01CatDiet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fats = Integer.parseInt(scanner.nextLine());
        int proteins = Integer.parseInt(scanner.nextLine());
        int carbs = Integer.parseInt(scanner.nextLine());
        int calories = Integer.parseInt(scanner.nextLine());
        int waterPercentage = Integer.parseInt(scanner.nextLine());

        double fatsInGrams = fats * calories * 1.0 / 900;
        double proteinsInGrams = proteins * calories * 1.0 / 400;
        double carbsInGrams = carbs * calories * 1.0 / 400;

        double foodWeight = fatsInGrams + proteinsInGrams + carbsInGrams;
        double caloriesPerGram = calories / foodWeight;
        double realFood = caloriesPerGram * (100 - waterPercentage * 1.0) / 100;

        System.out.printf("%.4f%n", realFood);
    }
}
