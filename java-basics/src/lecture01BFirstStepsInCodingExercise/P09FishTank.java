package lecture01BFirstStepsInCodingExercise;

import java.util.Scanner;

public class P09FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        int aqVolume = length * width * height;
        double litresVolume = aqVolume / 1000.0;

        double litresNeeded = litresVolume - (litresVolume * percent / 100);

        System.out.println(litresNeeded);
    }
}
