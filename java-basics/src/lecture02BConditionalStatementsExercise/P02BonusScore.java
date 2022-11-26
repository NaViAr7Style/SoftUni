package lecture02BConditionalStatementsExercise;

import java.util.Scanner;

public class P02BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int points = Integer.parseInt(scanner.nextLine());
        double bonusPoints = 0;

        if (points <= 100) {
            bonusPoints = 5;
        } else if (points <= 1000) {
            bonusPoints = points * 0.2;
        } else {
            bonusPoints = points * 0.1;
        }

        if (points % 2 == 0) {
            bonusPoints += 1;
        } else if (points % 10 == 5) {
            bonusPoints += 2;
        }

        System.out.println(bonusPoints);
        System.out.println(points + bonusPoints);
    }
}
