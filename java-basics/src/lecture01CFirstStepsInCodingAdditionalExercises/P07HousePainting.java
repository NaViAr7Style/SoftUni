package lecture01CFirstStepsInCodingAdditionalExercises;

import java.util.Scanner;

public class P07HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double greenArea = x * x * 2 - 1.2 * 2 + x * y * 2 - 1.5 * 1.5 * 2;
        double redArea = x * y * 2 + x * h;

        double greenPaint = greenArea / 3.4;
        double redPaint = redArea / 4.3;

        System.out.printf("%.2f%n", greenPaint);
        System.out.printf("%.2f%n", redPaint);
    }
}
