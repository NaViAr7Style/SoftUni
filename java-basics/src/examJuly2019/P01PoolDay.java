package examJuly2019;

import java.util.Scanner;

public class P01PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int headCount = Integer.parseInt(scanner.nextLine());
        double entranceFee = Double.parseDouble(scanner.nextLine());
        double sunbedPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double entranceExpenses = headCount * entranceFee;
        double sunbedCount = Math.ceil(headCount * 0.75);
        double umbrellaCount = Math.ceil(headCount * 0.5);
        double sunbedExpenses = sunbedCount * sunbedPrice;
        double umbrellaExpenses = umbrellaCount * umbrellaPrice;

        double allExpenses = entranceExpenses + sunbedExpenses + umbrellaExpenses;

        System.out.printf("%.2f lv.%n", allExpenses);
    }
}
