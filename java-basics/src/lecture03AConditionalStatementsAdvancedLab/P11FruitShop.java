package lecture03AConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P11FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double finalCost = 0;
        boolean isInvalid = false;

        if (!(dayOfWeek.equals("Monday") || dayOfWeek.equals("Tuesday") || dayOfWeek.equals("Wednesday") || dayOfWeek.equals("Thursday") ||
        dayOfWeek.equals("Friday") || dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday"))) {
            isInvalid = true;
        }

        if (!(fruit.equals("banana") || fruit.equals("apple") || fruit.equals("orange") || fruit.equals("grapefruit") || fruit.equals("kiwi") ||
        fruit.equals("pineapple") || fruit.equals("grapes"))) {
            isInvalid = true;
        }

        switch (dayOfWeek) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                 switch (fruit) {
                     case "banana":
                         finalCost = quantity * 2.50;
                         break;
                     case "apple":
                         finalCost = quantity * 1.20;
                         break;
                     case "orange":
                         finalCost = quantity * 0.85;
                         break;
                     case "grapefruit":
                         finalCost = quantity * 1.45;
                         break;
                     case "kiwi":
                         finalCost = quantity * 2.70;
                         break;
                     case "pineapple":
                         finalCost = quantity * 5.50;
                         break;
                     case "grapes":
                         finalCost = quantity * 3.85;
                         break;
                 }
                break;
            case "Saturday":
            case "Sunday":
                switch (fruit) {
                    case "banana":
                        finalCost = quantity * 2.70;
                        break;
                    case "apple":
                        finalCost = quantity * 1.25;
                        break;
                    case "orange":
                        finalCost = quantity * 0.90;
                        break;
                    case "grapefruit":
                        finalCost = quantity * 1.60;
                        break;
                    case "kiwi":
                        finalCost = quantity * 3.00;
                        break;
                    case "pineapple":
                        finalCost = quantity * 5.60;
                        break;
                    case "grapes":
                        finalCost = quantity * 4.20;
                        break;
                }
                break;
        }

        if (!isInvalid) {
            System.out.printf("%.2f%n", finalCost);
        } else {
            System.out.println("error");
        }
    }
}
