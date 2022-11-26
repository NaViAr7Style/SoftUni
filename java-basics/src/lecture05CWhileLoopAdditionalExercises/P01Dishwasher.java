package lecture05CWhileLoopAdditionalExercises;

import java.util.Scanner;

public class P01Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottlesDetergent = Integer.parseInt(scanner.nextLine());

        int detergentInMl = bottlesDetergent * 750;
        int counter = 1;
        int platesCleaned = 0;
        int potsCleaned = 0;
        boolean isDepleted = false;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int dishesCount = Integer.parseInt(input);

            if (counter % 3 == 0) {
                detergentInMl -= dishesCount * 15;
                potsCleaned += dishesCount;
            } else {
                detergentInMl -= dishesCount * 5;
                platesCleaned += dishesCount;
            }

            if (detergentInMl < 0) {
                isDepleted = true;
                break;
            }

            counter++;
            input = scanner.nextLine();
        }

        if (isDepleted) {
            System.out.printf("Not enough detergent, %d ml. more necessary!%n", -detergentInMl);
        } else {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", platesCleaned, potsCleaned);
            System.out.printf("Leftover detergent %d ml.%n", detergentInMl);
        }
    }
}
