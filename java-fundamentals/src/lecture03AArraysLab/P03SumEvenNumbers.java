package lecture03AArraysLab;

import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] strArr = input.split(" ");

        int sum = 0;

        for (String i : strArr) {
            int currentNum = Integer.parseInt(i);
            if (currentNum % 2 == 0) {
                sum += currentNum;
            }
        }

        System.out.println(sum);
    }
}
