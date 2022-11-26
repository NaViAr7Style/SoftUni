package lecture03CConditionalStatementsAdvancedAdditionalExercises;

import java.util.Scanner;

public class P05Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String housing = "";
        String location = "";
        double cost = 0;

        if (budget <= 1000) {
            housing = "Camp";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    cost = budget * 0.65;
                    break;
                case "Winter":
                    location = "Morocco";
                    cost = budget * 0.45;
                    break;
            }
        } else if (budget <= 3000) {
            housing = "Hut";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    cost = budget * 0.8;
                    break;
                case "Winter":
                    location = "Morocco";
                    cost = budget * 0.6;
                    break;
            }
        } else {
            housing = "Hotel";
            cost = budget * 0.9;
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    break;
                case "Winter":
                    location = "Morocco";
                    break;
            }
        }

        System.out.printf("%s - %s - %.2f%n", location, housing, cost);
    }
}
