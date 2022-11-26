package lecture07BAssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            resources.putIfAbsent(resource, 0);
            int currentQuantity = resources.get(resource);
            resources.put(resource, currentQuantity + quantity);

            input = scanner.nextLine();
        }

        resources.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
