package lecture03AArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int values = numArr.length;

        while (values > 1) {
            int[] updatedArr = new int[values - 1];

            for (int i = 0; i < updatedArr.length; i++) {
                updatedArr[i] = numArr[i] + numArr[i + 1];
                numArr[i] = updatedArr[i];
            }

            values--;
        }

        System.out.println(numArr[0]);
    }
}
