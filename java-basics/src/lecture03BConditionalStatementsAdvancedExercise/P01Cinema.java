package lecture03BConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieType = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        int seats = rows * columns;

        double revenue = switch (movieType) {
            case "Premiere" -> seats * 12.00;
            case "Normal" -> seats * 7.50;
            case "Discount" -> seats * 5.00;
            default -> 0;
        };

        System.out.printf("%.2f leva%n", revenue);
    }
}