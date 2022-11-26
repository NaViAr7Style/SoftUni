package lecture01BFirstStepsInCodingExercise;

import java.util.Scanner;

public class P05SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int detergent = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double penPrice = pens * 5.80;
        double markerPrice = markers * 7.20;
        double detergentPrice = detergent * 1.20;

        double normalPrice = penPrice + markerPrice + detergentPrice;
        double finalPrice = normalPrice - (normalPrice * discount / 100);

        System.out.println(finalPrice);
    }
}
