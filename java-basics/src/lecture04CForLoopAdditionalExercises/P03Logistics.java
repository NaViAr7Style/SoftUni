package lecture04CForLoopAdditionalExercises;

import java.util.Scanner;

public class P03Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cargoCount = Integer.parseInt(scanner.nextLine());

        int busWeight = 0;
        int truckWeight = 0;
        int trainWeight = 0;
        int totalWeight = 0;

        for (int i = 1; i <= cargoCount; i++) {
            int cargoWeight = Integer.parseInt(scanner.nextLine());
            totalWeight += cargoWeight;

            if (cargoWeight <= 3) {
                busWeight += cargoWeight;
            } else if (cargoWeight <= 11) {
                truckWeight += cargoWeight;
            } else {
                trainWeight += cargoWeight;
            }
        }

        double averagePrice = (busWeight * 200 + truckWeight * 175 + trainWeight * 120) * 1.0 / totalWeight;

        System.out.printf("%.2f%n", averagePrice);
        System.out.printf("%.2f%%%n", busWeight * 100.0 / totalWeight);
        System.out.printf("%.2f%%%n", truckWeight * 100.0 / totalWeight);
        System.out.printf("%.2f%%%n", trainWeight * 100.0 / totalWeight);
    }
}
