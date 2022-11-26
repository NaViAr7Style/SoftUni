package lecture07AExamPreparation;

import java.util.Scanner;

public class P02FootballResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstMatch = scanner.nextLine();
        String secondMatch = scanner.nextLine();
        String thirdMatch = scanner.nextLine();

        int won = 0;
        int lost = 0;
        int draws = 0;

        int firstHome = firstMatch.charAt(0);
        int firstAway = firstMatch.charAt(2);
        int secondHome = secondMatch.charAt(0);
        int secondAway = secondMatch.charAt(2);
        int thirdHome = thirdMatch.charAt(0);
        int thirdAway = thirdMatch.charAt(2);

        if (firstHome > firstAway) {
            won++;
        } else if (firstHome < firstAway) {
            lost++;
        } else {
            draws++;
        }

        if (secondHome > secondAway) {
            won++;
        } else if (secondHome < secondAway) {
            lost++;
        } else {
            draws++;
        }

        if (thirdHome > thirdAway) {
            won++;
        } else if (thirdHome < thirdAway) {
            lost++;
        } else {
            draws++;
        }

        System.out.printf("Team won %d games.%n", won);
        System.out.printf("Team lost %d games.%n", lost);
        System.out.printf("Drawn games: %d%n", draws);
    }
}
