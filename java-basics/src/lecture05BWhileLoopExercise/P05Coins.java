package lecture05BWhileLoopExercise;

import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());

        int changeInCoins = (int) (change * 100);
        int coinCounter = 0;

        while (changeInCoins > 0) {
            if (changeInCoins >= 200) {
                coinCounter++;
                changeInCoins -= 200;
            } else if (changeInCoins >= 100) {
                coinCounter++;
                changeInCoins -= 100;
            } else if (changeInCoins >= 50) {
                coinCounter++;
                changeInCoins -= 50;
            } else if (changeInCoins >= 20) {
                coinCounter++;
                changeInCoins -= 20;
            } else if (changeInCoins >= 10) {
                coinCounter++;
                changeInCoins -= 10;
            } else if (changeInCoins >= 5) {
                coinCounter++;
                changeInCoins -= 5;
            } else if (changeInCoins >= 2) {
                coinCounter++;
                changeInCoins -= 2;
            } else {
                coinCounter++;
                changeInCoins -= 1;
            }
        }

        System.out.println(coinCounter);
    }
}
