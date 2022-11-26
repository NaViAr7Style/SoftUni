package examApr2022;

import java.util.Scanner;

public class P05PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodStocked = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int foodLeft = foodStocked * 1000;

        while (!input.equals("Adopted")) {
            int foodEaten = Integer.parseInt(input);
            foodLeft -= foodEaten;
            input = scanner.nextLine();
        }

        if (foodLeft >= 0) {
            System.out.printf("Food is enough! Leftovers: %d grams.%n", foodLeft);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.%n", -foodLeft);
        }
    }
}
