package lecture03BArraysExercise;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] wagons = new int[n];
        int sum = 0;

        for (int i = 0; i < wagons.length; i++) {
            wagons[i] = Integer.parseInt(scanner.nextLine());
            sum += wagons[i];
        }

        for (int wagon : wagons) {
            System.out.printf("%d ", wagon);
        }
        System.out.println();
        System.out.println(sum);
    }
}
