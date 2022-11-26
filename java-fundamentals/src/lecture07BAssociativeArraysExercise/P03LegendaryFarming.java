package lecture07BAssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Map<String, Integer> collectedItems = new LinkedHashMap<>();

        collectedItems.put("shards", 0);
        collectedItems.put("fragments", 0);
        collectedItems.put("motes", 0);

        for (int i = 0; i < input.length; i += 2) {
            int quantity = Integer.parseInt(input[i]);
            String items = input[i + 1].toLowerCase();

            collectedItems.putIfAbsent(items, 0);
            int currentQuantity = collectedItems.get(items);
            collectedItems.put(items, currentQuantity + quantity);

            if (collectedItems.get("shards") >= 250 || collectedItems.get("fragments") >= 250 || collectedItems.get("motes") >= 250) {
                break;
            }

            if (i == input.length - 2) {
                input = scanner.nextLine().split(" ");
                i = -2;
            }
        }

        if (collectedItems.get("shards") >= 250) {
            System.out.println("Shadowmourne obtained!");
            int remainingQuantity = collectedItems.get("shards") - 250;
            collectedItems.put("shards", remainingQuantity);
        }
        if (collectedItems.get("fragments") >= 250) {
            System.out.println("Valanyr obtained!");
            int remainingQuantity = collectedItems.get("fragments") - 250;
            collectedItems.put("fragments", remainingQuantity);
        }
        if (collectedItems.get("motes") >= 250) {
            System.out.println("Dragonwrath obtained!");
            int remainingQuantity = collectedItems.get("motes") - 250;
            collectedItems.put("motes", remainingQuantity);
        }

        for (Map.Entry<String, Integer> entry : collectedItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
