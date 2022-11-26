package lecture03BSetsAndMapsAdvancedExercise;

import java.util.*;

public class P11LegendaryFarming {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Map<String, Integer> collectedItems = new TreeMap<>();

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

        Map<String, Integer> valueItems = new LinkedHashMap<>();

        valueItems.put("fragments", collectedItems.get("fragments"));
        collectedItems.remove("fragments");

        valueItems.put("motes", collectedItems.get("motes"));
        collectedItems.remove("motes");

        valueItems.put("shards", collectedItems.get("shards"));
        collectedItems.remove("shards");

        Set<Map.Entry<String, Integer>> entries = valueItems.entrySet();

        List<Map.Entry<String, Integer>> valuables = new ArrayList<>(entries);

        valuables.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        for (var valuable : valuables) {
            System.out.println(valuable.getKey() + ": " + valuable.getValue());
        }

        for (Map.Entry<String, Integer> entry : collectedItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}