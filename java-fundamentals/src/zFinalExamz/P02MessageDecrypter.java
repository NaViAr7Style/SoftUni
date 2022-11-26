package zFinalExamz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("^([$%])([A-Z][a-z]{2,})\\1: \\[(\\d+)\\]\\|\\[(\\d+)\\]\\|\\[(\\d+)\\]\\|$");

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group(2);

                char firstChar = (char) Integer.parseInt(matcher.group(3));
                char secondChar = (char) Integer.parseInt(matcher.group(4));
                char thirdChar = (char) Integer.parseInt(matcher.group(5));

                System.out.println(tag + ": " + firstChar + secondChar + thirdChar);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}