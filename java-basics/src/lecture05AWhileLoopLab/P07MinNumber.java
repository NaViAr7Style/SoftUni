package lecture05AWhileLoopLab;

import java.util.Scanner;

public class P07MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int min = Integer.MAX_VALUE;

        while (!input.equals("Stop")) {
            int currentNum = Integer.parseInt(input);

            if (min > currentNum) {
                min = currentNum;
            }

            input = scanner.nextLine();
        }

        System.out.println(min);
    }
}
