package lecture03BArraysExercise;

import java.util.Scanner;

public class P10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasureChest = scanner.nextLine().split("\\|");
        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("Yohoho!")) {
            String[] commandSplit = command.split(" ");

            switch (commandSplit[0]) {
                case "Loot":
                    for (int i = 1; i < commandSplit.length; i++) {
                        boolean alreadyContained = false;

                        for (int j = 0; j < treasureChest.length; j++) {
                            if (commandSplit[i].equals(treasureChest[j])) {
                                alreadyContained = true;
                                break;
                            }
                        }

                        if (!alreadyContained) {
                            String newChest = commandSplit[i] + " " + String.join(" ", treasureChest);
                            treasureChest = newChest.split(" ");
                        }
                    }
                    break;
                case "Drop":
                    int droppedItem = Integer.parseInt(commandSplit[1]);
                    if (droppedItem <= 0 || treasureChest.length - 1 <= droppedItem) {
                        break;
                    }

                    String newChest = "";
                    for (int i = 0; i < treasureChest.length; i++) {
                        if (i == droppedItem) {
                            continue;
                        }

                        newChest += treasureChest[i] + " ";
                    }

                    newChest = newChest + treasureChest[droppedItem];
                    treasureChest = newChest.split(" ");
                    break;
                case "Steal":
                    int stolenCount = Integer.parseInt(commandSplit[1]);
                    if (stolenCount > treasureChest.length) {
                        stolenCount = treasureChest.length;
                    }
                    String remainingChest = "";
                    String stolenItems = "";

                    for (int i = 0; i < treasureChest.length; i++) {
                        if (i < treasureChest.length - stolenCount) {
                            remainingChest += treasureChest[i] + " ";
                        } else {
                            if (i == treasureChest.length - 1) {
                                stolenItems += treasureChest[i];
                            } else {
                                stolenItems += treasureChest[i] + ", ";
                            }

                        }
                    }
                    System.out.println(stolenItems);
                    treasureChest = remainingChest.split(" ");
                    break;
            }

            command = scanner.nextLine();
        }

        int characterSum = 0;

        for (String element : treasureChest) {
            characterSum += element.length();
        }

        double treasureGain = characterSum * 1.0 / treasureChest.length;

        if (treasureGain == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", treasureGain);
        }
    }
}
