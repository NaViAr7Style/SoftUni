package lecture04BMethodsExercise;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        middleChar(input);
    }

    public static void middleChar(String string) {
        if (string.length() % 2 == 1) {
            System.out.println(string.charAt(string.length() / 2));
        } else {
            System.out.println(string.charAt(string.length() / 2 - 1) + "" + string.charAt(string.length() / 2));
        }
    }
}
