package lecture02CDataTypesAndVariablesAdditionalExercises;

import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());

        double eps = 0.000001;

        if (Math.abs(firstNum - secondNum) < eps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
