package lecture01CFirstStepsInCodingAdditionalExercises;

import java.util.Scanner;

public class P10WeatherForecastPart2s2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double temperature = Double.parseDouble(scanner.nextLine());

        switch (
                (26.00 <= temperature && temperature <= 35.00) ? 1 :
                        (20.1 <= temperature && temperature <= 25.9) ? 2 :
                                (15.00 <= temperature && temperature <= 20.00) ? 3 :
                                        (12.00 <= temperature && temperature <= 14.9) ? 4 :
                                                (5.00 <= temperature && temperature <= 11.9) ? 5 : 6
        ) {
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
            case 6:
                System.out.println("unknown");
                break;
        }
    }
}
