package lecture07AAssociativeArraysLab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> occurrences = new TreeMap<>();

        for (Double num : numList) {
            occurrences.putIfAbsent(num, 0);
            int count = occurrences.get(num);
            occurrences.put(num, count + 1);

//            if (occurrences.containsKey(num)) {
//                int count = occurrences.get(num);
//                occurrences.put(num, count + 1);
//            } else {
//                occurrences.put(num, 1);
//            }
        }

        for (Map.Entry<Double, Integer> entry : occurrences.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }

    }
}
