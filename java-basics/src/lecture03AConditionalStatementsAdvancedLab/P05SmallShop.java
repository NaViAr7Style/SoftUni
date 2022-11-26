package lecture03AConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P05SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double finalCost = switch (city) {
            case "Sofia" -> switch (product) {
                case "coffee" -> quantity * 0.50;
                case "water" -> quantity * 0.80;
                case "beer" -> quantity * 1.20;
                case "sweets" -> quantity * 1.45;
                case "peanuts" -> quantity * 1.60;
                default -> 0;
            };
            case "Plovdiv" -> switch (product) {
                case "coffee" -> quantity * 0.40;
                case "water" -> quantity * 0.70;
                case "beer" -> quantity * 1.15;
                case "sweets" -> quantity * 1.30;
                case "peanuts" -> quantity * 1.50;
                default -> 0;
            };
            case "Varna" -> switch (product) {
                case "coffee" -> quantity * 0.45;
                case "water" -> quantity * 0.70;
                case "beer" -> quantity * 1.10;
                case "sweets" -> quantity * 1.35;
                case "peanuts" -> quantity * 1.55;
                default -> 0;
            };
            default -> 0;
        };

        System.out.println(finalCost);
    }
}
