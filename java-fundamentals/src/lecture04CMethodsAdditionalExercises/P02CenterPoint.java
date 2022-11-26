package lecture04CMethodsAdditionalExercises;

import java.util.Scanner;

public class P02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        closest(x1, y1, x2, y2);
    }

    public static void closest(int a, int b, int c, int d) {
        int x1 = Math.abs(a);
        int y1 = Math.abs(b);
        int x2 = Math.abs(c);
        int y2 = Math.abs(d);

        double h1 = Math.sqrt(x1 * x1 + y1 * y1);
        double h2 = Math.sqrt(x2 * x2 + y2 * y2);

        double e = 0.00001;

        if (h1 - h2 > e) {
            System.out.printf("(%d, %d)%n", c, d);
        } else {
            System.out.printf("(%d, %d)%n", a, b);
        }
    }
}
