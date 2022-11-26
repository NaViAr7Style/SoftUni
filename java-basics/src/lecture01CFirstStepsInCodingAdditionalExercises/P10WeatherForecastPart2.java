package lecture01CFirstStepsInCodingAdditionalExercises;

import java.util.Scanner;

public class P10WeatherForecastPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double temperature = Double.parseDouble(scanner.nextLine());

        int weather = 0;

        if (26.00 <= temperature && temperature <= 35.00) {
            weather = 1;
        }
        if (20.1 <= temperature && temperature <= 25.9) {
            weather = 2;
        }
        if (15.00 <= temperature && temperature <= 20.00) {
            weather = 3;
        }
        if (12.00 <= temperature && temperature <= 14.9) {
            weather = 4;
        }
        if (5.00 <= temperature && temperature <= 11.9) {
            weather = 5;
        }

        switch (weather) {
            case 1:
                System.out.println("Hot");
                break;
            case 2:
                System.out.println("Warm");
                break;
            case 3:
                System.out.println("Mild");
                break;
            case 4:
                System.out.println("Cool");
                break;
            case 5:
                System.out.println("Cold");
                break;
            default:
                System.out.println("unknown");
        }
    }
}
