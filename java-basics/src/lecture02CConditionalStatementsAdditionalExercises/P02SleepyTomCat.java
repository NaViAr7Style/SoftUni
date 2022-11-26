package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOff = Integer.parseInt(scanner.nextLine());
        int workDays = 365 - daysOff;

        int sleepNorm = 30000 - workDays * 63 - daysOff * 127;
        int hours = Math.abs(sleepNorm) / 60;
        int minutes = Math.abs(sleepNorm) % 60;

        if (sleepNorm >= 0) {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play%n", hours, minutes);
        } else {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play%n", hours, minutes);
        }
    }
}
