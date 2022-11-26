package lecture04CMethodsAdditionalExercises;

import java.util.Scanner;

public class P03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        double firstLine = line(x1, y1, x2, y2);
        double secondLine = line(x3, y3, x4, y4);

        if (firstLine >= secondLine) {
            closest(x1, y1, x2, y2);
        } else {
            closest(x3, y3, x4, y4);
        }
    }

    public static void closest(int a, int b, int c, int d) {
        int x1 = Math.abs(a);
        int y1 = Math.abs(b);
        int x2 = Math.abs(c);
        int y2 = Math.abs(d);

        double h1 = Math.sqrt(x1 * x1 + y1 * y1);
        double h2 = Math.sqrt(x2 * x2 + y2 * y2);

        if (h1 > h2) {
            System.out.printf("(%d, %d)(%d, %d)%n", c, d, a, b);
        } else {
            System.out.printf("(%d, %d)(%d, %d)%n", a, b, c, d);
        }
    }

    public static double line(int a, int b, int c, int d) {
        return Math.sqrt(Math.abs((a - c) * (a - c)) + Math.abs((b - d) * (b - d)));
    }
}
