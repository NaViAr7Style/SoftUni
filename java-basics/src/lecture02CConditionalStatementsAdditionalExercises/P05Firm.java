package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P05Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int employees = Integer.parseInt(scanner.nextLine());

        int productiveHours = (int) Math.floor(days * 0.9 * 8);
        int overtime = employees * days * 2;
        int totalHours = productiveHours + overtime;

        if (totalHours >= hoursNeeded) {
            System.out.printf("Yes!%d hours left.%n", totalHours - hoursNeeded);
        } else {
            System.out.printf("Not enough time!%d hours needed.%n", hoursNeeded - totalHours);
        }
    }
}
