package lecture03ASetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedNumArr = Arrays.stream(scanner.nextLine().split(" "))
                               .map(Integer::parseInt)
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList());

        int top3elements = 3;

        while (top3elements-- > 0 && !sortedNumArr.isEmpty()) {
            System.out.printf("%d ", sortedNumArr.get(0));
            sortedNumArr.remove(0);
        }
    }
}