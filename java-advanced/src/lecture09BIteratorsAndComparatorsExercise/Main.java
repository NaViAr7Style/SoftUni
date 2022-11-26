package lecture09BIteratorsAndComparatorsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack();

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            if (command.equals("Pop")) {
                stack.pop();
            } else {
                String[] input = command.split(", ");
                input[0] = input[0].split(" ")[1];
                int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                stack.push(arr);
            }

            command = scanner.nextLine();
        }

        for (int i : stack) {
            System.out.println(i);
        }

        for (int i : stack) {
            System.out.println(i);
        }
    }
}