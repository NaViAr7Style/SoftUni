package midTerm02Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        int index = Integer.parseInt(scanner.nextLine());
        String costType = scanner.nextLine();

        int leftCost = 0;
        int rightCost = 0;
        int value = numList.get(index);

        if (costType.equals("cheap")) {
            for (int i = 0; i < index; i++) {
                if (numList.get(i) < value) {
                    leftCost += numList.get(i);
                }
            }
            for (int i = index + 1; i < numList.size(); i++) {
                if (numList.get(i) < value) {
                    rightCost += numList.get(i);
                }
            }
        } else if (costType.equals("expensive")) {
            for (int i = 0; i < index; i++) {
                if (numList.get(i) >= value) {
                    leftCost += numList.get(i);
                }
            }
            for (int i = index + 1; i < numList.size(); i++) {
                if (numList.get(i) >= value) {
                    rightCost += numList.get(i);
                }
            }
        }

        if (leftCost >= rightCost) {
            System.out.printf("Left - %d%n", leftCost);
        } else {
            System.out.printf("Right - %d%n", rightCost);
        }

    }
}
