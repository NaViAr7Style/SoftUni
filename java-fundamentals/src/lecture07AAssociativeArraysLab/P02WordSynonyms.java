package lecture07AAssociativeArraysLab;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> vocabulary = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!vocabulary.containsKey(word)) {
                vocabulary.put(word, new ArrayList<>());
            }
            vocabulary.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : vocabulary.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
