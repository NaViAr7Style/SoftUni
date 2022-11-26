package lecture02BConditionalStatementsExercise;

import java.util.Scanner;

public class P05GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double movieBudget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double outfitPrice = Double.parseDouble(scanner.nextLine());

        double decor = movieBudget * 0.1;
        double outfitCost = extras * outfitPrice;

        if (extras > 150) {
            outfitCost *= 0.9;
        }

        double totalCost = decor + outfitCost;
        double budgetLeft = movieBudget - totalCost;

        if (budgetLeft >= 0) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.%n", budgetLeft);
        } else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.%n", Math.abs(budgetLeft));
        }
    }
}
