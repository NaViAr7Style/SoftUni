package lecture03AArraysLab;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] strArr = input.split(" ");

        for (int i = 0; i < strArr.length / 2; i++) {
            String current = strArr[i];
            strArr[i] = strArr[strArr.length - 1 - i];
            strArr[strArr.length - 1 - i] = current;
        }

        for (String s : strArr) {
            System.out.print(s + " ");
        }

        System.out.println();
    }
}
