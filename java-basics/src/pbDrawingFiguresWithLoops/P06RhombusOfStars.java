package pbDrawingFiguresWithLoops;

import java.util.Scanner;

public class P06RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int incline = n - 1;
        int width = 1;

        for (int firstHalf = 1; firstHalf <= n; firstHalf++) {

            for (int spaces = incline; spaces > 0; spaces--) {
                System.out.print(" ");
            }
            for (int stars = 1; stars <= width; stars++) {
                System.out.print("* ");
            }
            incline --;
            width++;
            System.out.println();
        }
        incline = 1;
        width = n - 1;
        for (int secondHalf = n - 1; secondHalf >= 1; secondHalf--) {
            for (int spaces = 1; spaces <= incline; spaces++) {
                System.out.print(" ");
            }
            for (int stars = width; stars >= 1; stars--) {
                System.out.print("* ");
            }
            incline++;
            width--;
            System.out.println();
        }
    }
}
