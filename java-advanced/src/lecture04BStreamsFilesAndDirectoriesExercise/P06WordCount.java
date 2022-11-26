package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class P06WordCount {

    public static void main(String[] args) throws IOException {

        Scanner wordScanner = new Scanner(new FileReader("resources/words.txt"));

        Map<String, Integer> map = new HashMap<>();

        while (wordScanner.hasNext()) {
            String[] wordsToSearch = wordScanner.nextLine().split(" ");

            for (String word : wordsToSearch) {
                map.put(word, 0);
            }
        }

        Scanner fileScanner = new Scanner(new FileReader("resources/text.txt"));

        while (fileScanner.hasNext()) {
            String word = fileScanner.next();

            if (map.containsKey(word)) {
                int occurrences = map.get(word);
                occurrences++;
                map.put(word, occurrences);
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("resources/results.txt"));

        map.entrySet().stream()
                .sorted((f, s) -> s.getValue() - f.getValue())
                .forEach(entry -> pw.printf("%s - %d%n", entry.getKey(), entry.getValue()));

        wordScanner.close();
        fileScanner.close();
        pw.close();
    }
}