package lecture03BArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("end")) {
            String[] commandSplit = command.split(" ");

            switch (commandSplit[0]) {
                case "swap":
                    int firstIndex = Integer.parseInt(commandSplit[1]);
                    int secondIndex = Integer.parseInt(commandSplit[2]);
                    int placeholder = input[firstIndex];
                    input[firstIndex] = input[secondIndex];
                    input[secondIndex] = placeholder;
                    break;
                case "multiply":
                    int first = Integer.parseInt(commandSplit[1]);
                    int second = Integer.parseInt(commandSplit[2]);
                    input[first] *= input[second];
                    break;
                case "decrease":
                    for (int i = 0; i < input.length; i++) {
                        input[i] -= 1;
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < input.length - 1; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println(input[input.length - 1]);
    }
}
