package lecture04AMethodsLab;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f%n", calculateRectangleArea(a, b));
    }

    public static double calculateRectangleArea(double a,double b) {
        return a * b;
    }
}
