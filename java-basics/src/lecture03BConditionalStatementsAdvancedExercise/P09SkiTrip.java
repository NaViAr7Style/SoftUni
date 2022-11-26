package lecture03BConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String housing = scanner.nextLine();
        String evaluation = scanner.nextLine();
        int nights = days - 1;
        double finalCost = 0;

        switch (housing) {
            case "room for one person":
                finalCost = nights * 18;
                if (evaluation.equals("positive")) {
                    finalCost *= 1.25;
                } else if (evaluation.equals("negative")) {
                    finalCost *= 0.9;
                }
                break;
            case "apartment":
                if (days < 10) {
                    finalCost = nights * 25 * 0.7;
                } else if (days <= 15) {
                    finalCost = nights * 25 * 0.65;
                } else {
                    finalCost = nights * 25 * 0.5;
                }
                if (evaluation.equals("positive")) {
                    finalCost *= 1.25;
                } else if (evaluation.equals("negative")) {
                    finalCost *= 0.9;
                }
                break;
            case "president apartment":
                if (days < 10) {
                    finalCost = nights * 35 * 0.9;
                } else if (days <= 15) {
                    finalCost = nights * 35 * 0.85;
                } else {
                    finalCost = nights * 35 * 0.8;
                }
                if (evaluation.equals("positive")) {
                    finalCost *= 1.25;
                } else if (evaluation.equals("negative")) {
                    finalCost *= 0.9;
                }
                break;
        }

        System.out.printf("%.2f%n", finalCost);
    }
}
