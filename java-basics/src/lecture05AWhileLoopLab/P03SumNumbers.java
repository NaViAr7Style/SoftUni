package lecture05AWhileLoopLab;

import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int breakpoint = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (sum < breakpoint) {
            int i = Integer.parseInt(scanner.nextLine());
            sum += i;
        }

        System.out.println(sum);
    }
}
