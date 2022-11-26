package zFinalExamz;

import java.util.Scanner;

public class P01Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String spell = scanner.nextLine();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Abracadabra")) {
            String[] tokens = commandLine.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Abjuration":
                    spell = spell.toUpperCase();
                    System.out.println(spell);
                    break;
                case "Necromancy":
                    spell = spell.toLowerCase();
                    System.out.println(spell);
                    break;
                case "Illusion":
                    int index = Integer.parseInt(tokens[1]);
                    char letter = tokens[2].charAt(0);

                    if (0 <= index && index < spell.length()) {
                        spell = spell.substring(0, index) + letter + spell.substring(index + 1);
                        System.out.println("Done!");
                    } else {
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case "Divination":
                    String substringToReplace = tokens[1];
                    String replacement = tokens[2];

                    if (spell.contains(substringToReplace)) {
                        spell = spell.replaceAll(substringToReplace, replacement);
                        System.out.println(spell);
                    }
                    break;
                case "Alteration":
                    String substringToRemove = tokens[1];

                    if (spell.contains(substringToRemove)) {
                        spell = spell.replaceAll(substringToRemove, "");
                        System.out.println(spell);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
            }

            commandLine = scanner.nextLine();
        }
    }
}
