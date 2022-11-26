package lecture03BConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double studioFinalPrice = 0;
        double apartmentFinalPrice = 0;

        switch (month) {
            case "May":
            case "October":
                if (nights <= 7) {
                    studioFinalPrice = nights * 50;
                    apartmentFinalPrice = nights * 65;
                } else if (nights <= 14) {
                    studioFinalPrice = nights * 50 * 0.95;
                    apartmentFinalPrice = nights * 65;
                } else {
                    studioFinalPrice = nights * 50 * 0.7;
                    apartmentFinalPrice = nights * 65 * 0.9;
                }
                break;
            case "June":
            case "September":
                if (nights <= 14) {
                    studioFinalPrice = nights * 75.2;
                    apartmentFinalPrice = nights * 68.7;
                } else {
                    studioFinalPrice = nights * 75.2 * 0.8;
                    apartmentFinalPrice = nights * 68.7 * 0.9;
                }
                break;
            case "July":
            case "August":
                if (nights <= 14) {
                    studioFinalPrice = nights * 76;
                    apartmentFinalPrice = nights * 77;
                } else {
                    studioFinalPrice = nights * 76;
                    apartmentFinalPrice = nights * 77 * 0.9;
                }
                break;
        }

        System.out.printf("Apartment: %.2f lv.%n", apartmentFinalPrice);
        System.out.printf("Studio: %.2f lv.%n", studioFinalPrice);
    }
}
