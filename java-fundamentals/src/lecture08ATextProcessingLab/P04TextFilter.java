package lecture08ATextProcessingLab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWords) {
            String replacement = "*".repeat(word.length());
            text = text.replace(word, replacement);
        }

        System.out.println(text);
    }
}
