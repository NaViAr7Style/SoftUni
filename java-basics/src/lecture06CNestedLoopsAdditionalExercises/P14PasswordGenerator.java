package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P14PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int bigger;
                if (i > j) {
                    bigger = i;
                } else {
                    bigger = j;
                }

                for (char k = 97; k < 97 + l; k++) {
                    for (char m = 97; m < 97 + l; m++) {
                        for (int o = bigger + 1; o <= n; o++) {
                            System.out.printf("%d%d%s%s%d ", i, j, k, m, o);
                        }
                    }
                }
            }
        }
    }
}
