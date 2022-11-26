package lecture01ABasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int ticketPrice = 0;
        boolean isNotValid = age < 0 || age > 122;

        switch (dayType) {
            case "Weekday":
                if (age <= 18 || age > 64) {
                    ticketPrice = 12;
                } else {
                    ticketPrice = 18;
                }
                break;
            case "Weekend":
                if (age <= 18 || age > 64) {
                    ticketPrice = 15;
                } else {
                    ticketPrice = 20;
                }
                break;
            case "Holiday":
                if (age <= 18) {
                    ticketPrice = 5;
                } else if (age <= 64) {
                    ticketPrice = 12;
                } else {
                    ticketPrice = 10;
                }
                break;
        }

        if (!isNotValid) {
            System.out.printf("%d$%n", ticketPrice);
        } else {
            System.out.println("Error!");
        }
    }
}
