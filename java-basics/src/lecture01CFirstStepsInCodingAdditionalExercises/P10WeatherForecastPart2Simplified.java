package lecture01CFirstStepsInCodingAdditionalExercises;

import java.util.Scanner;

public class P10WeatherForecastPart2Simplified {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double temperature = Double.parseDouble(scanner.nextLine());

        if (26.0 <= temperature && temperature <= 35.0) {
            System.out.println("Hot");
        } else if (20.1 <= temperature && temperature <= 25.9) {
            System.out.println("Warm");
        } else if (15.0 <= temperature && temperature <= 20.0) {
            System.out.println("Mild");
        } else if (12.0 <= temperature && temperature <= 14.9) {
            System.out.println("Cool");
        } else if (5.0 <= temperature && temperature <= 11.9) {
            System.out.println("Cold");
        } else {
            System.out.println("unknown");
        }
    }
}
