package lecture01BFirstStepsInCodingExercise;

import java.util.Scanner;

public class P01UsdToBgn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountUsd = Double.parseDouble(scanner.nextLine());
        double amountBgn = amountUsd * 1.79549;

        System.out.println(amountBgn);
    }
}
