package lecture03BArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int startingIndex = 0;
        int equalElementsCounter = 1;
        int maxSequence = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] == input[i]) {
                equalElementsCounter++;
            } else {
                equalElementsCounter = 1;
            }

            if (maxSequence < equalElementsCounter) {
                maxSequence = equalElementsCounter;
                startingIndex = i - equalElementsCounter + 1;
            }
        }

        for (int i = startingIndex; i < startingIndex + maxSequence; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
