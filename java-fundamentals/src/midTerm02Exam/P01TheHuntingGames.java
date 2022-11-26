package midTerm02Exam;

import java.util.Scanner;

public class P01TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double energy = Double.parseDouble(scanner.nextLine());
        double waterPerPerson = Double.parseDouble(scanner.nextLine());
        double foodPerPerson = Double.parseDouble(scanner.nextLine());

        double totalWater = days * players * waterPerPerson;
        double totalFood = days * players * foodPerPerson;
        boolean energyDepleted = false;

        for (int i = 1; i <= days; i++) {
            double energyLost = Double.parseDouble(scanner.nextLine());
            energy -= energyLost;

            if (energy <= 0) {
                energyDepleted = true;
                break;
            }

            if (i % 2 == 0) {
                energy *= 1.05;
                totalWater *= 0.7;
            }

            if (i % 3 == 0) {
                energy *= 1.1;
                totalFood -= totalFood / players;
            }
        }

        if (!energyDepleted) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!%n", energy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.%n", totalFood, totalWater);
        }
    }
}
