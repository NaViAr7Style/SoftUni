package lecture02AConditionalStatementsLab;

import java.util.Scanner;

public class P07AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        double area;

        switch (type) {
            case "square" -> {
                double side = Double.parseDouble(scanner.nextLine());

                area = side * side;
            }
            case "rectangle" -> {
                double sideA = Double.parseDouble(scanner.nextLine());
                double sideB = Double.parseDouble(scanner.nextLine());

                area = sideA * sideB;
            }
            case "circle" -> {
                double radius = Double.parseDouble(scanner.nextLine());

                area = radius * radius * Math.PI;
            }
            case "triangle" -> {
                double side = Double.parseDouble(scanner.nextLine());
                double height = Double.parseDouble(scanner.nextLine());

                area = side * height * 0.5;
            }
            default -> area = 0;
        }

        System.out.printf("%.3f%n", area);
    }
}
