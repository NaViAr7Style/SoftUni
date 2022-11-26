package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P07SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumMax = Integer.parseInt(scanner.nextLine());
        int secondNumMax = Integer.parseInt(scanner.nextLine());
        int maxPasswords = Integer.parseInt(scanner.nextLine());

        int passwordsGenerated = 0;
        boolean isEnough = false;
        int a = 35;
        int b = 64;

        for (int i = 1; i <=  firstNumMax; i++) {
            for (int j = 1; j <= secondNumMax; j++) {
                char asciiA = (char) a;
                char asciiB = (char) b;

                System.out.printf("%s%s%d%d%s%s|", asciiA, asciiB, i, j, asciiB, asciiA);

                a++;
                b++;
                passwordsGenerated++;

                if (a > 55) {
                    a = 35;
                }
                if (b > 96) {
                    b = 64;
                }

                if (passwordsGenerated >= maxPasswords) {
                    isEnough = true;
                    break;
                }
            }

            if (isEnough) {
                break;
            }
        }

        System.out.println();
    }
}
