package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P04CarNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int lastNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= lastNum; i++) {
            for (int j = firstNum; j <= lastNum; j++) {
                for (int k = firstNum; k <= lastNum; k++) {
                    if ((j + k) % 2 == 0) {
                        for (int l = firstNum; l < i; l++) {
                            if ((i % 2 == 0 && l % 2 == 1) || (i % 2 == 1 && l % 2 == 0)) {
                                System.out.printf("%d%d%d%d ", i, j, k, l);
                            }
                        }
                    }
                }
            }
        }
    }
}
