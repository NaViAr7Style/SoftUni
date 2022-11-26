package lecture04CForLoopAdditionalExercises;

import java.util.Scanner;

public class P01BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inheritedMoney = Double.parseDouble(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());

        int age = 18;
        double remainingMoney = inheritedMoney;

        for (int i = 1800; i <= year ; i++) {
            if (i % 2 == 0) {
                remainingMoney -= 12000;
            } else {
                remainingMoney -= 12000 + 50 * age;
            }

            age++;
        }

        if (remainingMoney >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.%n", remainingMoney);
        } else {
            System.out.printf("He will need %.2f dollars to survive.%n", remainingMoney * (-1));
        }
    }
}
