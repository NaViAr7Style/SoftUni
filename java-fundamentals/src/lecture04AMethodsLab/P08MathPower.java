package lecture04AMethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        double result = mathPower(num, power);

        DecimalFormat df = new DecimalFormat("0.#######");

        System.out.println(df.format(result));
    }

    public static double mathPower(double a, int b) {
        double result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        return result;
    }
}
