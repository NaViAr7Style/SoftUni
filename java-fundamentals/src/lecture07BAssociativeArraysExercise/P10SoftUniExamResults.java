package lecture07BAssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> studentResults = new LinkedHashMap<>();
        Map<String, Integer> languageSubmissions = new LinkedHashMap<>();


        while (!input.equals("exam finished")) {
            String username = input.split("-")[0];

            if (input.contains("banned")) {
                studentResults.remove(username);
                input = scanner.nextLine();
                continue;
            }

            String language = input.split("-")[1];
            int points = Integer.parseInt(input.split("-")[2]);

            languageSubmissions.putIfAbsent(language, 0);
            languageSubmissions.put(language, languageSubmissions.get(language) + 1);

            studentResults.putIfAbsent(username, 0);

            if (studentResults.get(username) < points) {
                studentResults.put(username, points);
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");

        for (Map.Entry<String, Integer> entry : studentResults.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }

        System.out.println("Submissions:");

        for (Map.Entry<String, Integer> entry : languageSubmissions.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
