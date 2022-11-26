package examApr2022;

import java.util.Scanner;

public class P06GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int locationsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= locationsCount; i++) {
            double expectedAvgYield = Double.parseDouble(scanner.nextLine());
            int daysMined = Integer.parseInt(scanner.nextLine());

            double totalGoldMined = 0;

            for (int j = 1; j <= daysMined; j++) {
                double goldMined = Double.parseDouble(scanner.nextLine());
                totalGoldMined += goldMined;
            }

            double averageGoldPerDay = totalGoldMined / daysMined;

            if (averageGoldPerDay >= expectedAvgYield) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", averageGoldPerDay);
            } else {
                System.out.printf("You need %.2f gold.%n", expectedAvgYield - averageGoldPerDay);
            }
        }
    }
}
