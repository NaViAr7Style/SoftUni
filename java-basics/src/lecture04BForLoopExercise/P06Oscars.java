package lecture04BForLoopExercise;

import java.util.Scanner;

public class P06Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int judgesCount = Integer.parseInt(scanner.nextLine());

        double totalPoints = academyPoints;

        for (int i = 1; i <= judgesCount ; i++) {
            String judgeName = scanner.nextLine();
            double judgePoints = Double.parseDouble(scanner.nextLine());

            totalPoints += judgeName.length() * judgePoints / 2;

            if (totalPoints > 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!%n", actorName, totalPoints);
                break;
            }
        }

        if (totalPoints <= 1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!%n", actorName, 1250.5 - totalPoints);
        }
    }
}
