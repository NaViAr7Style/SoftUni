package lecture05CListsAdditionalExercises;

import java.util.*;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int loopCounter = Math.min(firstList.size(), secondList.size());

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < loopCounter; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(secondList.size() - i - 1));
        }

        int a;
        int b;

        if (firstList.size() > secondList.size()) {
            a = firstList.get(firstList.size() - 2);
            b = firstList.get(firstList.size() - 1);
        } else {
            a = secondList.get(0);
            b = secondList.get(1);
        }

        int lowEnd;
        int highEnd;

        if (a > b) {
            lowEnd = b;
            highEnd = a;
        } else {
            lowEnd = a;
            highEnd = b;
        }

        int finalLowEnd = lowEnd;
        int finalHighEnd = highEnd;
        result = result.stream().filter(e -> finalLowEnd < e && e < finalHighEnd).collect(Collectors.toList());

        Collections.sort(result);

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
