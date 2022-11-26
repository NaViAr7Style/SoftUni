package examPrepApr2022;

import java.util.Scanner;

public class P05ExcursionSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seaTripsAvailable = Integer.parseInt(scanner.nextLine());
        int mountainTripsAvailable = Integer.parseInt(scanner.nextLine());

        int totalRevenue = 0;
        int seaTripsLeft = seaTripsAvailable;
        int mountainTripsLeft = mountainTripsAvailable;
        boolean isSoldOut = false;
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            if (input.equals("sea") && seaTripsLeft != 0) {
                totalRevenue += 680;
                seaTripsLeft--;
            } else if (input.equals("mountain") && mountainTripsLeft != 0) {
                totalRevenue += 499;
                mountainTripsLeft--;
            }

            if (seaTripsLeft == 0 && mountainTripsLeft == 0) {
                isSoldOut = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (isSoldOut) {
            System.out.println("Good job! Everything is sold.");
        }

        System.out.printf("Profit: %d leva.%n", totalRevenue);
    }
}
