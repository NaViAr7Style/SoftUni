package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P08SecretDoorsLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hundreds = Integer.parseInt(scanner.nextLine());
        int tens = Integer.parseInt(scanner.nextLine());
        int ones = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= hundreds; i += 2) {
            for (int j = 2; j <= tens; j++) {
                boolean isNonPrime = false;
                for (int k = 2; k <= j / 2; k++) {
                    if (j % k == 0) {
                        isNonPrime = true;
                        break;
                    }
                }

                if (isNonPrime) {
                    continue;
                } else {
                    for (int k = 2; k <= ones ; k += 2) {
                        System.out.printf("%d %d %d%n", i, j, k);
                    }
                }
            }
        }
    }
}
