package lecture07AExamPreparation;

import java.util.Scanner;

public class P03MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String duration = scanner.nextLine();
        String contractType = scanner.nextLine();
        String addedNet = scanner.nextLine();
        int months = Integer.parseInt(scanner.nextLine());

        double costPerMonth = switch (duration) {
            case "one" -> switch (contractType) {
                case "Small" -> 9.98;
                case "Middle" -> 18.99;
                case "Large" -> 25.98;
                case "ExtraLarge" -> 35.99;
                default -> 0;
            };
            case "two" -> switch (contractType) {
                case "Small" -> 8.58;
                case "Middle" -> 17.09;
                case "Large" -> 23.59;
                case "ExtraLarge" -> 31.79;
                default -> 0;
            };
            default -> 0;
        };

        if (addedNet.equals("yes")) {
            if (costPerMonth <= 10) {
                costPerMonth += 5.50;
            } else if (costPerMonth <= 30) {
                costPerMonth += 4.35;
            } else {
                costPerMonth += 3.85;
            }
        }

        double totalCost = months * costPerMonth;

        if (duration.equals("two")) {
            totalCost *= 0.9625;
        }

        System.out.printf("%.2f lv.%n", totalCost);
    }
}
