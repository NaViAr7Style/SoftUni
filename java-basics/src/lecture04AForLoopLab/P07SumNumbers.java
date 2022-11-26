package lecture04AForLoopLab;

import java.util.Scanner;

public class P07SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 1; i <= count; i++) {
            int j = Integer.parseInt(scanner.nextLine());

            sum += j;
        }

        System.out.println(sum);
    }
}
