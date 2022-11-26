package lecture02BDataTypesAndVariablesExercise;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kegCount = Integer.parseInt(scanner.nextLine());
        String largestKegType = "";
        double largestKegVolume = 0;

        for (int i = 1; i <= kegCount; i++) {
            String kegType = scanner.nextLine();
            double kegRadius = Double.parseDouble(scanner.nextLine());
            int kegHeight = Integer.parseInt(scanner.nextLine());

            double kegVolume = kegRadius * kegRadius * kegHeight * Math.PI;

            if (kegVolume > largestKegVolume) {
                largestKegVolume = kegVolume;
                largestKegType = kegType;
            }

        }

        System.out.println(largestKegType);
    }
}
