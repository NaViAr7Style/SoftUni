package lecture03CArraysAdditionalExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int currentSampleIndex = 0;
        int bestSampleIndex = 0;
        int[] bestDna = new int[arrayLength];
        int bestSum = 0;
        int longestSampleSequence = 0;
        int bestStartingIndex = arrayLength;

        while (!input.equals("Clone them!")) {
            currentSampleIndex++;
            int currentSum = 0;
            int[] currentDna = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();
            int currentSequence = 0;
            int longestSequenceInThisSample = 0;
            int bestStartingIndexInThisSample = arrayLength;
            int zeroesCounter = 0;

            for (int i = 0; i < currentDna.length; i++) {

                if (currentDna[i] == 1) {

                    currentSequence++;
                    currentSum++;
                    int currentStartingIndex = i - currentSequence + 1;

                    if (currentSequence > longestSequenceInThisSample) {
                        longestSequenceInThisSample = currentSequence;
                        bestStartingIndexInThisSample = currentStartingIndex;
                    }

                    if (longestSequenceInThisSample > longestSampleSequence) {
                        longestSampleSequence = longestSequenceInThisSample;
                        bestSum = currentSum;
                        bestSampleIndex = currentSampleIndex;
                        bestStartingIndex = bestStartingIndexInThisSample;
                        bestDna = currentDna;
                    } else if (longestSequenceInThisSample == longestSampleSequence) {
                        if (bestStartingIndex > bestStartingIndexInThisSample) {
                            bestSum = currentSum;
                            bestSampleIndex = currentSampleIndex;
                            bestStartingIndex = bestStartingIndexInThisSample;
                            bestDna = currentDna;
                        } else if (currentSum > bestSum) {
                            bestSum = currentSum;
                            bestSampleIndex = currentSampleIndex;
                            bestDna = currentDna;
                        }
                    }
                } else {
                    zeroesCounter++;
                    currentSequence = 0;
                }
            }
            if (zeroesCounter == arrayLength) {
                bestSampleIndex = 1;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSampleIndex, bestSum);
        System.out.println(Arrays.toString(bestDna).replaceAll("[\\[\\],]", ""));
    }
}
