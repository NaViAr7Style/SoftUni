package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P13PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDouble = Integer.parseInt(scanner.nextLine());
        int secondDouble = Integer.parseInt(scanner.nextLine());
        int firstRestriction = Integer.parseInt(scanner.nextLine());
        int secondRestriction = Integer.parseInt(scanner.nextLine());

        for (int i = firstDouble; i <= firstDouble + firstRestriction; i++) {
            boolean isNonPrime = false;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isNonPrime = true;
                    break;
                }
            }

            if (isNonPrime) {
                continue;
            } else {
                for (int j = secondDouble; j <= secondDouble + secondRestriction; j++) {
                    boolean isNonPrimeToo = false;
                    for (int k = 2; k <= j / 2; k++) {
                        if (j % k == 0) {
                            isNonPrimeToo = true;
                            break;
                        }
                    }

                    if (isNonPrimeToo) {
                        continue;
                    } else {
                        System.out.println(i * 100 + j);
                    }
                }
            }
        }
    }
}
