package lecture04BForLoopExercise;

import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washerPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int toyCount = 0;
        int savedMoney = 0;
        int prizedMoney = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                prizedMoney += 10;
                savedMoney += prizedMoney - 1;
            } else {
                toyCount++;
            }
        }

        savedMoney += toyCount * toyPrice;

        if (savedMoney >= washerPrice) {
            System.out.printf("Yes! %.2f%n", savedMoney - washerPrice);
        } else {
            System.out.printf("No! %.2f%n", washerPrice - savedMoney);
        }
    }
}
