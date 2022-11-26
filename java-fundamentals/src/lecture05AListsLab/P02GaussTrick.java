package lecture05AListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int iterations = numbersList.size() / 2;

        for (int i = 0; i < iterations; i++) {
            numbersList.set(i, numbersList.get(i) + numbersList.get(numbersList.size() - 1));
            numbersList.remove(numbersList.size() - 1);
        }

//      System.out.println(numbersList.toString().replace("[", "").replace("]", "").replace(",", ""));
        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
