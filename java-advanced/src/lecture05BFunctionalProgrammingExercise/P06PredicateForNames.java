package lecture05BFunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int allowedLength = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> validNames = name -> name.length() <= allowedLength;

        names.stream().filter(validNames).forEach(System.out::println);
    }
}