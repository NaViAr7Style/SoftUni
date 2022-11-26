package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P04TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double finalCost = 0;
        double taxiPrice = 0;
        double busPrice = distance * 0.09;
        double trainPrice = distance * 0.06;

        if (timeOfDay.equals("day")) {
            taxiPrice = 0.7 + 0.79 * distance;
        } else if (timeOfDay.equals("night")) {
            taxiPrice = 0.7 + 0.9 * distance;
        }

        if (distance < 20) {
            finalCost = taxiPrice;
        } else if (distance < 100) {
            finalCost = Math.min(taxiPrice, busPrice);
        } else {
            finalCost = Math.min(taxiPrice, trainPrice);
        }

        System.out.printf("%.2f%n", finalCost);
    }
}
