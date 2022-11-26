package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P06Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysAway = Integer.parseInt(scanner.nextLine());
        int kgFood = Integer.parseInt(scanner.nextLine());
        double dogFood = Double.parseDouble(scanner.nextLine());
        double catFood = Double.parseDouble(scanner.nextLine());
        double turtleFood = Double.parseDouble(scanner.nextLine());

        double foodNeeded = (dogFood + catFood + turtleFood * 0.001) * daysAway;

        if (kgFood >= foodNeeded) {
            System.out.printf("%.0f kilos of food left.%n", Math.floor(kgFood - foodNeeded));
        } else {
            System.out.printf("%.0f more kilos of food are needed.%n", Math.ceil(foodNeeded - kgFood));
        }
    }
}
