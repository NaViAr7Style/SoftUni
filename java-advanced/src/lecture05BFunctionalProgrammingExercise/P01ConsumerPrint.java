package lecture05BFunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Consumer<String> splitAndPrint = text -> Arrays.stream(text.split(" ")).forEach(System.out::println);

        splitAndPrint.accept(input);
    }
}