package lecture03ASetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> supermarkets = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            supermarkets.putIfAbsent(shop, new LinkedHashMap<>());
            supermarkets.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        for (var shop : supermarkets.entrySet()) {
            System.out.printf("%s->%n", shop.getKey());

            for (var product : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }
    }
}