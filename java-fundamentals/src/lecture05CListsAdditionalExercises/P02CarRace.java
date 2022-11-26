package lecture05CListsAdditionalExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double leftTime = 0;
        double rightTime = 0;

        for (int i = 0; i < numArray.length / 2; i++) {
            leftTime += numArray[i];
            if (numArray[i] == 0) {
                leftTime *= 0.8;
            }

            rightTime += numArray[numArray.length - i - 1];
            if (numArray[numArray.length - i - 1] == 0) {
                rightTime *= 0.8;
            }
        }

        if (leftTime < rightTime) {
            System.out.printf("The winner is left with total time: %.1f%n", leftTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f%n", rightTime);
        }
    }
}
