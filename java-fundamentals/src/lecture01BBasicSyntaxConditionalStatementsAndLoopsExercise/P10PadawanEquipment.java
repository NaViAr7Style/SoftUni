package lecture01BBasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int padawans = Integer.parseInt(scanner.nextLine());
        double lightSaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = padawans / 6;
        int neededLightSabers = (int) Math.ceil(padawans * 1.1);

        double totalCost = neededLightSabers * lightSaberPrice
                + padawans * robePrice
                + (padawans - freeBelts) * beltPrice;

        if (budget >= totalCost) {
            System.out.printf("The money is enough - it would cost %.2flv.%n", totalCost);
        } else {
            System.out.printf("George Lucas will need %.2flv more.%n", totalCost - budget);
        }
    }
}
