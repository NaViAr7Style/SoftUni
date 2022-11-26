package lecture04CForLoopAdditionalExercises;

import java.util.Scanner;

public class P07FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int fanCount = Integer.parseInt(scanner.nextLine());

        int countA = 0;
        int countB = 0;
        int countV = 0;
        int countG = 0;

        for (int i = 1; i <= fanCount; i++) {
            String fanSector = scanner.nextLine();

            switch (fanSector) {
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "V":
                    countV++;
                    break;
                case "G":
                    countG++;
                    break;
            }
        }

        System.out.printf("%.2f%%%n", countA * 100.0 / fanCount);
        System.out.printf("%.2f%%%n", countB * 100.0 / fanCount);
        System.out.printf("%.2f%%%n", countV * 100.0 / fanCount);
        System.out.printf("%.2f%%%n", countG * 100.0 / fanCount);
        System.out.printf("%.2f%%%n", fanCount * 100.0 / stadiumCapacity);
    }
}
