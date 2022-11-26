package lecture04BMethodsExercise;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);

        charsInRange(start, end);
        System.out.println();
    }

    public static void charsInRange(char first, char second) {
        if (first <= second) {
            for (int i = first + 1; i < second; i++) {
                char currentSymbol = (char) i;
                System.out.print(currentSymbol + " ");
            }
        } else {
            for (int i = second + 1; i < first; i++) {
                char currentSymbol = (char) i;
                System.out.print(currentSymbol + " ");
            }
        }
    }
}
