package lecture03BConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examTime = examHour * 60 + examMinute;
        int arrivalTime = arrivalHour * 60 + arrivalMinute;

        int statusTime = examTime - arrivalTime;
        int statusHour = Math.abs(statusTime) / 60;
        int statusMinute = Math.abs(statusTime) % 60;

        if (statusTime >= 0) {
            if (statusTime > 30) {
                System.out.println("Early");
                if (statusHour == 0) {
                    System.out.printf("%d minutes before the start%n", statusMinute);
                } else {
                    System.out.printf("%d:%02d hours before the start", statusHour, statusMinute);
                }
            } else {
                System.out.println("On time");
                if (statusMinute != 0) {
                    System.out.printf("%d minutes before the start%n", statusMinute);
                }
            }
        } else {
            System.out.println("Late");
            if (statusHour == 0) {
                System.out.printf("%d minutes after the start%n", statusMinute);
            } else {
                System.out.printf("%d:%02d hours after the start", statusHour, statusMinute);
            }
        }
    }
}
