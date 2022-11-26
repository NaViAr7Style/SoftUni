package lecture05AFunctionalProgrammingLab;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int start = Integer.parseInt(tokens[0]);
        int end = Integer.parseInt(tokens[1]);

        String filter = scanner.nextLine();

        IntPredicate predicate = n -> filter.equals("odd") == (n % 2 != 0);

        String output = IntStream.rangeClosed(start, end)
                .filter(predicate)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}