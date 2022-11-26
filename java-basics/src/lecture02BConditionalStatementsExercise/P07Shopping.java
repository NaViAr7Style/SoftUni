package lecture02BConditionalStatementsExercise;

import java.util.Scanner;

public class P07Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int gpuCount = Integer.parseInt(scanner.nextLine());
        int cpuCount = Integer.parseInt(scanner.nextLine());
        int ramCount = Integer.parseInt(scanner.nextLine());

        int gpuCost = gpuCount * 250;
        double cpuCost = gpuCost * 0.35 * cpuCount;
        double ramCost = gpuCost * 0.10 * ramCount;

        double totalCost = gpuCost + cpuCost + ramCost;

        if (gpuCount > cpuCount) {
            totalCost *= 0.85;
        }

        double difference = budget - totalCost;

        if (difference >= 0) {
            System.out.printf("You have %.2f leva left!%n", difference);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!%n", Math.abs(difference));
        }
    }
}
