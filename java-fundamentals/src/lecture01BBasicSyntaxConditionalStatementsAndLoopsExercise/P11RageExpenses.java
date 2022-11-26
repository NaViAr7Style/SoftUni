package lecture01BBasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetCost = Double.parseDouble(scanner.nextLine());
        double mouseCost = Double.parseDouble(scanner.nextLine());
        double keyboardCost = Double.parseDouble(scanner.nextLine());
        double monitorCost = Double.parseDouble(scanner.nextLine());

        int headsetsBroken = lostGames / 2;
        int mousesBroken = lostGames / 3;
        int keyboardsBroken = lostGames / 6;
        int monitorsBroken = lostGames / 12;

        double totalCost = headsetsBroken * headsetCost
                            + mousesBroken * mouseCost
                            + keyboardsBroken * keyboardCost
                            + monitorsBroken * monitorCost;

        System.out.printf("Rage expenses: %.2f lv.%n", totalCost);
    }
}
