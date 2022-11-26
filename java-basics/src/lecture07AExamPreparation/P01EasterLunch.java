package lecture07AExamPreparation;

import java.util.Scanner;

public class P01EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreadCount = Integer.parseInt(scanner.nextLine());
        int eggBaskets = Integer.parseInt(scanner.nextLine());
        int cookiesInKg = Integer.parseInt(scanner.nextLine());

        double breadCost = easterBreadCount * 3.20;
        double eggsCost = eggBaskets * 4.35;
        double cookiesCost = cookiesInKg * 5.40;
        double paintCost = eggBaskets * 12 * 0.15;

        double totalCost = breadCost + eggsCost + cookiesCost + paintCost;

        System.out.printf("%.2f%n", totalCost);
    }
}
