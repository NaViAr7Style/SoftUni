package lecture05BFunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Consumer<String> splitAndPrint = text -> Arrays.stream(text.split(" ")).forEach(e -> System.out.println("Sir " + e));

        splitAndPrint.accept(input);
    }
}