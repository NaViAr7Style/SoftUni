package lecture03ASetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] numArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        for (double num : numArray) {
            occurrences.putIfAbsent(num, 0);
            int count = occurrences.get(num);
            occurrences.replace(num, count + 1);
        }

        for (var entry : occurrences.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}