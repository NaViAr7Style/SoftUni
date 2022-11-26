package zFinalExamPrep01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@#])([A-Za-z]{3,})\\1{2}([A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> mirrorWords = new ArrayList<>();
        int pairCounter = 0;

        while (matcher.find()) {
            pairCounter++;
            String firstWord = matcher.group(2);
            String secondWord = matcher.group(3);

            StringBuilder secondWordBuilder = new StringBuilder(secondWord);
            String secondWordReversed = secondWordBuilder.reverse().toString();

            if (firstWord.equals(secondWordReversed)) {
                String pair = firstWord + " <=> " + secondWord;
                mirrorWords.add(pair);
            }
        }

        if (pairCounter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", pairCounter);
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(mirrorWords.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}