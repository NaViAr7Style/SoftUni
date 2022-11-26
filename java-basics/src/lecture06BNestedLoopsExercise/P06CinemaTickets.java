package lecture06BNestedLoopsExercise;

import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;

        while (!input.equals("Finish")) {
            String movieName = input;
            int theaterSeats = Integer.parseInt(scanner.nextLine());
            int ticketCounter = 0;

            for (int i = 1; i <= theaterSeats; i++) {
                String ticketType = scanner.nextLine();

                if (ticketType.equals("End")) {
                    break;
                }

                ticketCounter++;

                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        break;
                    case "standard":
                        standardTickets++;
                        break;
                    case "kid":
                        kidTickets++;
                        break;
                }
            }
            System.out.printf("%s - %.2f%% full.%n", movieName, ticketCounter * 100.0 / theaterSeats);

            input = scanner.nextLine();
        }

        int totalTickets = studentTickets + standardTickets + kidTickets;

        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", studentTickets * 100.0 / totalTickets);
        System.out.printf("%.2f%% standard tickets.%n", standardTickets * 100.0 / totalTickets);
        System.out.printf("%.2f%% kids tickets.%n", kidTickets * 100.0 / totalTickets);
    }
}
