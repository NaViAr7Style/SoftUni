package lecture07AAssociativeArraysLab;

import java.util.*;
import java.util.stream.Collectors;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Map<String, Integer> wordCountMap = new LinkedHashMap<>();

        for (String e : stringList) {
            String currentWord = e.toLowerCase();
            wordCountMap.putIfAbsent(currentWord, 0);
            int count = wordCountMap.get(currentWord);
            wordCountMap.put(currentWord, count + 1);
        }

        List<String> oddOccurrences = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddOccurrences.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", oddOccurrences));
    }
}
