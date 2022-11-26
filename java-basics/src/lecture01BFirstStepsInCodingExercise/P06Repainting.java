package lecture01BFirstStepsInCodingExercise;

import java.util.Scanner;

public class P06Repainting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nylon = parseIntLine(scanner);
        int paint = parseIntLine(scanner);
        int thinner = parseIntLine(scanner);
        int workHours = parseIntLine(scanner);

        double nylonExpenses = (nylon + 2) * 1.50;
        double paintExpenses = paint * 1.1 * 14.50;
        double thinnerExpenses = thinner * 5;
        double materialExpenses = nylonExpenses + paintExpenses + thinnerExpenses + 0.40;
        double workExpenses = materialExpenses * workHours * 0.3;

        System.out.println(materialExpenses + workExpenses);
    }

    public static int parseIntLine(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
