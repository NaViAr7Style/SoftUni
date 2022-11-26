package lecture04BMethodsExercise;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(vowelsCount(input));
    }

    public static int vowelsCount(String input) {
        int countOfVowels = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            switch (currentSymbol) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    countOfVowels++;
                    break;
            }

        }

        return countOfVowels;
    }
}
