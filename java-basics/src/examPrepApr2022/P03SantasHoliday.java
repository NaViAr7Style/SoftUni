package examPrepApr2022;

import java.util.Scanner;

public class P03SantasHoliday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysStayed = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String evaluation = scanner.nextLine();

        double roomCost = 0;

        switch (roomType) {
            case "room for one person":
                roomCost = 18;
                break;
            case "apartment":
                if (daysStayed < 10) {
                    roomCost = 25 * 0.70;
                } else if (daysStayed <= 15) {
                    roomCost = 25 * 0.65;
                } else {
                    roomCost = 25 * 0.50;
                }
                break;
            case "president apartment":
                if (daysStayed < 10) {
                    roomCost = 35 * 0.90;
                } else if (daysStayed <= 15) {
                    roomCost = 35 * 0.85;
                } else {
                    roomCost = 35 * 0.80;
                }
                break;
        }

        double totalCost = roomCost * (daysStayed - 1);

        if (evaluation.equals("positive")) {
            totalCost *= 1.25;
        } else if (evaluation.equals("negative")) {
            totalCost *= 0.90;
        }

        System.out.printf("%.2f%n", totalCost);
    }
}
