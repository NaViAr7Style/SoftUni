package lecture07AExamPreparation;

import java.util.Scanner;

public class P05SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double trunkCapacity = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        double spaceLeft = trunkCapacity;
        int suitcaseCounter = 0;
        boolean isFull = false;

        while (!input.equals("End")) {
            double suitcaseVolume = Double.parseDouble(input);
            suitcaseCounter++;

            if (suitcaseCounter % 3 == 0) {
                suitcaseVolume *= 1.1;
            }

            spaceLeft -= suitcaseVolume;

            if (spaceLeft < 0) {
                suitcaseCounter--;
                isFull = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (isFull) {
            System.out.println("No more space!");
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
        }

        System.out.printf("Statistic: %d suitcases loaded.%n", suitcaseCounter);
    }
}
