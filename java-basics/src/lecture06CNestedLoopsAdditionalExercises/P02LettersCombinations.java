package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P02LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLetter = scanner.nextLine();
        String secondLetter = scanner.nextLine();
        String skipLetter = scanner.nextLine();

        int firstAscii = firstLetter.charAt(0);
        int secondAscii = secondLetter.charAt(0);
        int skipAscii = skipLetter.charAt(0);
        int counter = 0;

        for (int i = firstAscii; i <= secondAscii ; i++) {
            if (i == skipAscii) {
                continue;
            }

            for (int j = firstAscii; j <= secondAscii; j++) {
                if (j == skipAscii) {
                    continue;
                }

                for (int k = firstAscii; k <= secondAscii; k++) {
                    if (k == skipAscii) {
                        continue;
                    }
                    char first = (char) i;
                    char second = (char) j;
                    char third = (char) k;

                    counter++;
                    System.out.printf("%s%s%s ", first, second, third);
                }
            }
        }

        System.out.println(counter);
    }
}
