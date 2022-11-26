package lecture08ATextProcessingLab;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();

        for (String s : input) {
            result.append(s.repeat(s.length()));
        }

        System.out.println(result);
    }
}