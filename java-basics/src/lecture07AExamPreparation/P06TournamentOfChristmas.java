package lecture07AExamPreparation;

import java.util.Scanner;

public class P06TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentDuration = Integer.parseInt(scanner.nextLine());

        double totalRaisedMoney = 0;
        int daysWonCounter = 0;
        int daysLostCounter = 0;

        for (int i = 1; i <= tournamentDuration; i++) {
            int winCounter = 0;
            int lossCounter = 0;
            double dailyRaisedMoney = 0;
            String sportType = scanner.nextLine();

            while (!sportType.equals("Finish")) {
                String outcome = scanner.nextLine();

                if (outcome.equals("win")) {
                    winCounter++;
                    dailyRaisedMoney += 20;
                } else if (outcome.equals("lose")) {
                    lossCounter++;
                }

                sportType = scanner.nextLine();
            }

            if (winCounter > lossCounter) {
                dailyRaisedMoney *= 1.1;
                daysWonCounter++;
            } else {
                daysLostCounter++;
            }

            totalRaisedMoney += dailyRaisedMoney;
        }

        if (daysWonCounter > daysLostCounter) {
            totalRaisedMoney *= 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f%n", totalRaisedMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f%n", totalRaisedMoney);
        }
    }
}
