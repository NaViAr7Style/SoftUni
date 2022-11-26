package zFinalExamPrep01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> composers = new LinkedHashMap<>();
        Map<String, String> keys = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];

            composers.put(piece, composer);
            keys.put(piece, key);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commandLine = input.split("\\|");
            String command = commandLine[0];
            String piece = commandLine[1];

            switch (command) {
                case "Add":
                    String composer = commandLine[2];
                    String key = commandLine[3];

                    if (composers.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        composers.put(piece, composer);
                        keys.put(piece, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (composers.containsKey(piece)) {
                        composers.remove(piece);
                        keys.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commandLine[2];

                    if (composers.containsKey(piece)) {
                        keys.replace(piece, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }

                    break;

            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : composers.entrySet()) {
            String piece = entry.getKey();
            String composer = entry.getValue();
            String key = keys.get(entry.getKey());

            System.out.printf("%s -> Composer: %s, Key: %s%n", piece, composer, key);
        }
    }
}
