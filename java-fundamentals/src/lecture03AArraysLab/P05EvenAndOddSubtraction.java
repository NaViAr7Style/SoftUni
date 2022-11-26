package lecture03AArraysLab;

import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] strArr = input.split(" ");

        int sumEven = 0;
        int sumOdd = 0;

        for (String i : strArr) {
            int currentNum = Integer.parseInt(i);
            if (currentNum % 2 == 0) {
                sumEven += currentNum;
            } else {
                sumOdd += currentNum;
            }
        }

        System.out.println(sumEven - sumOdd);
    }
}
