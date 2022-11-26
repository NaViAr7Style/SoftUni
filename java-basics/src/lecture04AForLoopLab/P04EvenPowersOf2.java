package lecture04AForLoopLab;

import java.util.Scanner;

public class P04EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= input; i += 2) {
                System.out.printf("%.0f%n", Math.pow(2, i));
        }
    }
}
