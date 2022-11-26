package lecture07BAssociativeArraysExercise;

import java.util.*;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Double> prices = new LinkedHashMap<>();
        Map<String, Integer> quantities = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] goods = input.split(" ");

            String product = goods[0];
            double price = Double.parseDouble(goods[1]);
            int quantity = Integer.parseInt(goods[2]);

            prices.put(product, price);
            quantities.putIfAbsent(product, 0);
            int currentQuantity = quantities.get(product);
            quantities.put(product, currentQuantity + quantity);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            String product = entry.getKey();
            double totalPrice = entry.getValue() * quantities.get(entry.getKey());
            System.out.printf("%s -> %.2f%n", product, totalPrice);
        }
    }
}
