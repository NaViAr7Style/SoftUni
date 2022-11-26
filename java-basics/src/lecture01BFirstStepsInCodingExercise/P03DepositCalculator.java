package lecture01BFirstStepsInCodingExercise;

import java.util.Scanner;

public class P03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double deposit = Double.parseDouble(scanner.nextLine());
        int period = Integer.parseInt(scanner.nextLine());
        double interest = Double.parseDouble(scanner.nextLine());

        double sum = deposit + period * ((deposit * interest / 100) / 12);

        System.out.println(sum);
    }
}
