package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poolVolume = Integer.parseInt(scanner.nextLine());
        int firstPipeDebit = Integer.parseInt(scanner.nextLine());
        int secondPipeDebit = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        double firstPipeVolume = firstPipeDebit * hours;
        double secondPipeVolume = secondPipeDebit * hours;

        double poolState = firstPipeVolume + secondPipeVolume;

        if (poolVolume >= poolState) {
            firstPipeVolume = firstPipeVolume / poolState * 100;
            secondPipeVolume = secondPipeVolume / poolState * 100;
            poolState = poolState / poolVolume * 100;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.%n", poolState, firstPipeVolume, secondPipeVolume);
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, poolState - poolVolume);
        }
    }
}
