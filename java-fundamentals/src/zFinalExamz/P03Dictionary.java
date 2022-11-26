package zFinalExamz;

import java.util.*;

public class P03Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" \\| ");

        Map<String, List<String>> dictionary = new LinkedHashMap<>();

        for (String semantic : input) {
            String word = semantic.split(": ")[0];
            String definition = semantic.split(": ")[1];

            dictionary.putIfAbsent(word, new ArrayList<>());
            dictionary.get(word).add(definition);
        }

        String[] testWords = scanner.nextLine().split(" \\| ");

        String command = scanner.nextLine();

        if (command.equals("Test")) {
            for (String testWord : testWords) {
                if (dictionary.containsKey(testWord)) {
                    System.out.printf("%s:%n", testWord);
                    for (String definition : dictionary.get(testWord)) {
                        System.out.printf(" -%s%n", definition);
                    }
                }
            }
        } else if (command.equals("Hand Over")) {
            System.out.println(String.join(" ", dictionary.keySet()));
        }
    }
}