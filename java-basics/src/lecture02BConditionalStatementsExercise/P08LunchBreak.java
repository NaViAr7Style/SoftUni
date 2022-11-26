package lecture02BConditionalStatementsExercise;

import java.util.Scanner;

public class P08LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String show = scanner.nextLine();
        int episodeDuration = Integer.parseInt(scanner.nextLine());
        int lunchBreak = Integer.parseInt(scanner.nextLine());

        double freeTime = lunchBreak * 5 / 8.0;
        double timeLeft = freeTime - episodeDuration;

        if (timeLeft >= 0) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", show, Math.ceil(timeLeft));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", show, Math.ceil(Math.abs(timeLeft)));
        }
    }
}
