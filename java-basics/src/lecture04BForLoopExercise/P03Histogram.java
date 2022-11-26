package lecture04BForLoopExercise;

import java.util.Scanner;

public class P03Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;

        for (int i = 1; i <= n ; i++) {
            int j = Integer.parseInt(scanner.nextLine());

            if (j < 200) {
                p1++;
            } else if (j < 400) {
                p2++;
            } else if (j < 600) {
                p3++;
            } else if (j < 800) {
                p4++;
            } else {
                p5++;
            }
        }

        System.out.printf("%.2f%%%n", p1 * 100.0 / n);
        System.out.printf("%.2f%%%n", p2 * 100.0 / n);
        System.out.printf("%.2f%%%n", p3 * 100.0 / n);
        System.out.printf("%.2f%%%n", p4 * 100.0 / n);
        System.out.printf("%.2f%%%n", p5 * 100.0 / n);
    }
}
