package lecture04BForLoopExercise;

import java.util.Scanner;

public class P08TennisRankList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentCount = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());

        int totalPoints = startingPoints;
        int tournamentsWon = 0;

        for (int i = 1; i <= tournamentCount ; i++) {
            String tournamentOutcome = scanner.nextLine();

            switch (tournamentOutcome) {
                case "W":
                    totalPoints += 2000;
                    tournamentsWon++;
                    break;
                case "F":
                    totalPoints += 1200;
                    break;
                case "SF":
                    totalPoints += 720;
                    break;
            }
        }

        double averagePoints = (totalPoints - startingPoints * 1.0) / tournamentCount;

        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %.0f%n", Math.floor(averagePoints));
        System.out.printf("%.2f%%%n", tournamentsWon * 100.0 / tournamentCount);
    }
}
