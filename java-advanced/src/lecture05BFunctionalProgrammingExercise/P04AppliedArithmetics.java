package lecture05BFunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                              .split("\\s+"))
                              .map(Integer::parseInt)
                               .collect(Collectors.toList());

        String input = scanner.nextLine();

        Consumer<List<Integer>> increment = list -> list.replaceAll(e -> e + 1);
        Consumer<List<Integer>> multiplyByTwo = list -> list.replaceAll(e -> e * 2);
        Consumer<List<Integer>> decrement = list -> list.replaceAll(e -> e - 1);
        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));

        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    increment.accept(numbers);
                    break;
                case "multiply":
                    multiplyByTwo.accept(numbers);
                    break;
                case "subtract":
                    decrement.accept(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}