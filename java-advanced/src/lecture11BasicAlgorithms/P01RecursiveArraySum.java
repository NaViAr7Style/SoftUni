package lecture11BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class P01RecursiveArraySum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(getSum(numArray, 0));
    }

    private static int getSum(int[] numArray, int index) {
        if (index == numArray.length - 1) {
            return numArray[index];
        }

        return numArray[index] + getSum(numArray, index + 1);
    }
}