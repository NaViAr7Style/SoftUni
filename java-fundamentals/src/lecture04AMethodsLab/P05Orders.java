package lecture04AMethodsLab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String item = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double finalCost = orderCost(item, quantity);

        System.out.printf("%.2f%n", finalCost);
    }

    public static double orderCost(String product, int quantity) {
        double productCost = 0;
        switch (product) {
            case "coffee":
                productCost = 1.50;
                break;
            case "water":
                productCost = 1.00;
                break;
            case "coke":
                productCost = 1.40;
                break;
            case "snacks":
                productCost = 2.00;
                break;
        }

        return productCost * quantity;
    }

}
