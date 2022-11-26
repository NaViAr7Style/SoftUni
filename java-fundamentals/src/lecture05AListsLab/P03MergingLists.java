package lecture05AListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int smallestSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < smallestSize; i++) {
            resultList.add(firstList.get(i));
            resultList.add(secondList.get(i));
        }

        if (firstList.size() > secondList.size()) {
            resultList.addAll(firstList.subList(smallestSize, firstList.size()));
        } else {
            resultList.addAll(secondList.subList(smallestSize, secondList.size()));
        }

        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}
