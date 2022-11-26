package lecture04CForLoopAdditionalExercises;

import java.util.Scanner;

public class P05GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int movesCount = Integer.parseInt(scanner.nextLine());

        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int invalids = 0;
        double result = 0;

        for (int i = 1; i <= movesCount; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());

            if (currentNum <= 9) {
                if (currentNum >= 0) {
                    result += currentNum * 0.2;
                    zeroes++;
                } else {
                    result /= 2;
                    invalids++;
                }
            } else if (currentNum <= 19) {
                result += currentNum * 0.3;
                ones++;
            } else if (currentNum <= 29) {
                result += currentNum * 0.4;
                twos++;
            } else if (currentNum <= 39) {
                result += 50;
                threes++;
            } else if (currentNum <= 50) {
                result += 100;
                fours++;
            } else {
                result /= 2;
                invalids++;
            }
        }

        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", zeroes * 100.0 / movesCount);
        System.out.printf("From 10 to 19: %.2f%%%n", ones * 100.0 / movesCount);
        System.out.printf("From 20 to 29: %.2f%%%n", twos * 100.0 / movesCount);
        System.out.printf("From 30 to 39: %.2f%%%n", threes * 100.0 / movesCount);
        System.out.printf("From 40 to 50: %.2f%%%n", fours * 100.0 / movesCount);
        System.out.printf("Invalid numbers: %.2f%%%n", invalids * 100.0 / movesCount);
    }
}
