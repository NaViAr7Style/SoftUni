package lecture05CListsAdditionalExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Integer> numList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (Character.isDigit(symbol)) {
                numList.add(Character.getNumericValue(symbol));
            } else {
                charList.add(symbol);
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numList.get(i));
            } else {
                skipList.add(numList.get(i));
            }
        }

        String result = "";
        int currentIndex = 0;

        for (int i = 0; i < takeList.size(); i++) {
            int take = takeList.get(i);
            int skip = skipList.get(i);

            for (int j = 0; j < take; j++) {
                result += charList.get(currentIndex + j);
            }

            currentIndex += take + skip;
        }

        System.out.println(result);
    }
}
