package examJuly2019;

import java.util.Scanner;

public class P03CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drinkType = scanner.nextLine();
        String sweetnessLevel = scanner.nextLine();
        int drinksCount = Integer.parseInt(scanner.nextLine());

        double drinkPrice = 0;

        switch (drinkType) {
            case "Espresso":
                switch (sweetnessLevel) {
                    case "Without":
                        drinkPrice = 0.90;
                        break;
                    case "Normal":
                        drinkPrice = 1.00;
                        break;
                    case "Extra":
                        drinkPrice = 1.20;
                        break;
                }
                break;
            case "Cappuccino":
                switch (sweetnessLevel) {
                    case "Without":
                        drinkPrice = 1.00;
                        break;
                    case "Normal":
                        drinkPrice = 1.20;
                        break;
                    case "Extra":
                        drinkPrice = 1.60;
                        break;
                }
                break;
            case "Tea":
                switch (sweetnessLevel) {
                    case "Without":
                        drinkPrice = 0.50;
                        break;
                    case "Normal":
                        drinkPrice = 0.60;
                        break;
                    case "Extra":
                        drinkPrice = 0.70;
                        break;
                }
                break;
        }

        double totalCost = drinkPrice * drinksCount;

        if (sweetnessLevel.equals("Without")) {
            totalCost *= 0.65;
        }
        if (drinkType.equals("Espresso") && drinksCount >= 5) {
            totalCost *= 0.75;
        }
        if (totalCost > 15) {
            totalCost *= 0.80;
        }

        System.out.printf("You bought %d cups of %s for %.2f lv.%n", drinksCount, drinkType, totalCost);
    }
}
