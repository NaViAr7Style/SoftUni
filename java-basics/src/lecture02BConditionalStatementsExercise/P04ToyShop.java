package lecture02BConditionalStatementsExercise;

import java.util.Scanner;

public class P04ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripCost = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        int toyCount = puzzles + dolls + teddyBears + minions + trucks;

        double puzzlesCost = puzzles * 2.60;
        double dollsCost = dolls * 3.00;
        double teddyBearsCost = teddyBears * 4.10;
        double minionsCost = minions * 8.20;
        double trucksCost = trucks * 2.00;

        double totalCost = puzzlesCost + dollsCost + teddyBearsCost + minionsCost + trucksCost;

        if (toyCount >= 50) {
            totalCost *= 0.75;
        }

        double profit = totalCost * 0.9;
        double difference = profit - tripCost;

        if (difference >= 0) {
            System.out.printf("Yes! %.2f lv left.%n", difference);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.%n", Math.abs(difference));
        }
    }
}
