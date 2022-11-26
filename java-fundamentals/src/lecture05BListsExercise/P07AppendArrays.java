package lecture05BListsExercise;

import java.util.*;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        List<String> numList = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {
            String[] currentArray = input[i].split("\\s+");

            numList.addAll(Arrays.asList(currentArray));
        }
        numList.removeIf(String::isEmpty);
        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
