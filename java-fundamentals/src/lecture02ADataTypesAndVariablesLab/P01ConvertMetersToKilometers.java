package lecture02ADataTypesAndVariablesLab;

import java.util.Scanner;

public class P01ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distanceInMeters = Integer.parseInt(scanner.nextLine());

        double distanceInKm = distanceInMeters * 1.0 / 1000;

        System.out.printf("%.2f%n", distanceInKm);
    }
}
