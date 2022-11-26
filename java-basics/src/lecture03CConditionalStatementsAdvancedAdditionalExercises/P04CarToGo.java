package lecture03CConditionalStatementsAdvancedAdditionalExercises;

import java.util.Scanner;

public class P04CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        if (budget <= 100) {
            System.out.println("Economy class");
            switch (season) {
                case "Summer":
                    System.out.printf("Cabrio - %.2f%n", budget * 0.35);
                    break;
                case "Winter":
                    System.out.printf("Jeep - %.2f%n", budget * 0.65);
                    break;
            }
        } else if (budget <= 500) {
            System.out.println("Compact class");
            switch (season) {
                case "Summer":
                    System.out.printf("Cabrio - %.2f%n", budget * 0.45);
                    break;
                case "Winter":
                    System.out.printf("Jeep - %.2f%n", budget * 0.80);
                    break;
            }
        } else {
            System.out.println("Luxury class");
            System.out.printf("Jeep - %.2f%n", budget * 0.9);
        }
    }
}
