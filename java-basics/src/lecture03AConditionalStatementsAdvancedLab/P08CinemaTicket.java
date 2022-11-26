package lecture03AConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P08CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayOfWeek = scanner.nextLine();

        switch (dayOfWeek) {
            case "Monday", "Tuesday", "Friday" -> System.out.println(12);
            case "Wednesday", "Thursday" -> System.out.println(14);
            case "Saturday", "Sunday" -> System.out.println(16);
            default -> System.out.println("invalid");
        }
    }
}
