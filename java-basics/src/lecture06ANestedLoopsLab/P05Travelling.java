package lecture06ANestedLoopsLab;

import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String destination = input;
            double tripCost = Double.parseDouble(scanner.nextLine());
            double savedMoney = 0;

            while (savedMoney < tripCost) {
                double installment = Double.parseDouble(scanner.nextLine());
                savedMoney += installment;
            }
            System.out.printf("Going to %s!%n", destination);

            input = scanner.nextLine();
        }
    }
}
