package lecture03BSetsAndMapsAdvancedExercise;

import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] compound = scanner.nextLine().split("\\s+");

            Collections.addAll(elements, compound);
        }

        String result = String.join(" ", elements);

        System.out.println(result);
    }
}