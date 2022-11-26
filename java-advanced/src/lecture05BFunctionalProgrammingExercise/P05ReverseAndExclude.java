package lecture05BFunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int denominator = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numList);

        numList.removeIf(e -> e % denominator == 0);

        numList.forEach(e -> System.out.print(e + " "));
    }
}