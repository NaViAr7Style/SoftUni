package lecture04CMethodsAdditionalExercises;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String value = scanner.nextLine();

        switch (type) {
            case "int":
                int intValue = Integer.parseInt(value);
                dataType(intValue);
                break;
            case "real":
                double doubleValue = Double.parseDouble(value);
                dataType(doubleValue);
                break;
            default:
                dataType(value);
        }
    }

    public static void dataType(int value) {
        System.out.println(value * 2);
    }

    public static void dataType(double value) {
        System.out.printf("%.2f%n", value * 1.5);
    }

    public static void dataType(String value) {
        System.out.println("$" + value + "$");
    }
}