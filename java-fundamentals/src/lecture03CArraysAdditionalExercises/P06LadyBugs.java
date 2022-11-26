package lecture03CArraysAdditionalExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] ladybugSpots = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] field = new int[size];

        for (int i = 0; i < field.length; i++) {
            field[i] = 0;
            for (int ladybugSpot : ladybugSpots) {
                if (ladybugSpot == i) {
                    field[i] = 1;
                    break;
                }
            }
        }

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {
            String[] command = input.split(" ");

            int ladybugIndex = Integer.parseInt(command[0]);
            int flyLength = Integer.parseInt(command[2]);

            if (ladybugIndex < 0 || ladybugIndex >= field.length) {
                input = scanner.nextLine();
                continue;
            }
            if (field[ladybugIndex] == 0) {
                input = scanner.nextLine();
                continue;
            }


            switch (command[1]) {
                case "left":
                    field[ladybugIndex] = 0;
                    for (int i = ladybugIndex - flyLength; i >= 0; i -= flyLength) {
                        if (i >= field.length || i < 0) {
                            break;
                        }
                        if (field[i] == 0) {
                            field[i] = 1;
                            break;
                        }
                    }
                    break;
                case "right":
                    field[ladybugIndex] = 0;
                    for (int i = ladybugIndex + flyLength; i < field.length; i += flyLength) {
                        if (i >= field.length || i < 0) {
                            break;
                        }
                        if (field[i] == 0) {
                            field[i] = 1;
                            break;
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(Arrays.toString(field).replaceAll("[\\[\\],]", ""));
    }
}
