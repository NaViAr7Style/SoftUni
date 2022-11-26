package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P01UniquePinCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());
        int thirdDigit = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= firstDigit; i += 2) {
            for (int j = 2; j <= secondDigit; j++) {
                boolean isNonPrime = false;
                for (int k = 2; k <= j / 2; k++) {
                    if (j % k == 0) {
                        isNonPrime = true;
                        break;
                    }
                }

                if (!isNonPrime) {
                    for (int k = 2; k <= thirdDigit ; k += 2) {
                        System.out.printf("%d %d %d%n", i, j, k);
                    }
                }
            }
        }
    }
}
