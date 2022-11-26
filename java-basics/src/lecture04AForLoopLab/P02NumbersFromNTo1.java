package lecture04AForLoopLab;

import java.util.Scanner;

public class P02NumbersFromNTo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = input; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
