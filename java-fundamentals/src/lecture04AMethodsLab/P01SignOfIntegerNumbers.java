package lecture04AMethodsLab;

import java.util.Scanner;

public class P01SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        signOf(num);
    }

    public static void signOf(int a) {
        if (a > 0) {
            System.out.printf("The number %d is positive.%n", a);
        } else if (a < 0) {
            System.out.printf("The number %d is negative.%n", a);
        } else {
            System.out.printf("The number %d is zero.%n", a);
        }
    }
}
