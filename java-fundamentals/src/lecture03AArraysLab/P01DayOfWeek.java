package lecture03AArraysLab;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] days = new String[] {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        int n = Integer.parseInt(scanner.nextLine());

        if (1 <= n && n <= 7) {
            System.out.println(days[n - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
