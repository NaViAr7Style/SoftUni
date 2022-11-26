package lecture05BFunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getMin = numArr -> Arrays.stream(numArr).min().orElse(0);

        System.out.println(getMin.apply(numArray));
    }
}