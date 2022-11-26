package lecture05CListsAdditionalExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String text = scanner.nextLine();

        String output = "";

        for (int i = 0; i < numList.size(); i++) {
            int index = getSum(numList.get(i));
            index %= text.length();
            output += characterAt(text, index);
            text = removeCharAt(text, index);
        }

        System.out.println(output);
    }

    public static int getSum(int a) {
        int sum = 0;
        while (a > 0) {
            int currentDigit = a % 10;
            sum += currentDigit;
            a /= 10;
        }

        return sum;
    }

    public static String characterAt(String text, int a) {
        char symbol = text.charAt(a);

        return "" + symbol;
    }

    public static String removeCharAt(String text, int a) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            if (i != a) {
                result += text.charAt(i);
            }
        }

        return result;
    }
}
