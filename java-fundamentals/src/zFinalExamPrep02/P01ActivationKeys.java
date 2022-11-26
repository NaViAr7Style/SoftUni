package zFinalExamPrep02;

import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">+");
            String command = tokens[0];
            int startIndex;
            int endIndex;
            String substring;

            switch (command) {
                case "Contains":
                    substring = tokens[1];

                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String type = tokens[1];
                    startIndex = Integer.parseInt(tokens[2]);
                    endIndex = Integer.parseInt(tokens[3]);
                    substring = activationKey.substring(startIndex, endIndex);

                    if (type.equals("Upper")) {
                        activationKey = activationKey.replace(substring, substring.toUpperCase());
                    } else if (type.equals("Lower")) {
                        activationKey = activationKey.replace(substring, substring.toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    substring = activationKey.substring(startIndex, endIndex);

                    activationKey = activationKey.replace(substring, "");
                    System.out.println(activationKey);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}