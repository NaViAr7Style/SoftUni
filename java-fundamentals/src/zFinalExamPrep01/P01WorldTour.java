package zFinalExamPrep01;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tour = scanner.nextLine();
        StringBuilder tourBuilder = new StringBuilder(tour);

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Travel")) {
            String[] tokens = commandLine.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt(tokens[1]);
                    String destination = tokens[2];

                    if (isValidIndex(insertIndex, tourBuilder)) {
                        tourBuilder.insert(insertIndex, destination);
                    }
                    break;
                case "Remove Stop":
                    int startingIndex = Integer.parseInt(tokens[1]);
                    int endingIndex = Integer.parseInt(tokens[2]);

                    if (isValidIndex(startingIndex, tourBuilder) && isValidIndex(endingIndex, tourBuilder)) {
                        tourBuilder.delete(startingIndex, endingIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    tourBuilder = new StringBuilder(tourBuilder.toString().replaceAll(oldString, newString));
                    break;
            }

            System.out.println(tourBuilder);
            commandLine = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + tourBuilder);
    }

    public static boolean isValidIndex(int index, StringBuilder text) {
        return 0 <= index && index < text.length();
    }
}
