package lecture02BDataTypesAndVariablesExercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalVolume = 0;

        for (int i = 1; i <= n; i++) {
            int currentVolume = Integer.parseInt(scanner.nextLine());

            if (totalVolume + currentVolume <= 255) {
                totalVolume += currentVolume;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(totalVolume);
    }
}
