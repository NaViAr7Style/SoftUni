package lecture04CForLoopAdditionalExercises;

import java.util.Scanner;

public class P06Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());

        double electricityBills = 0;
        double waterBills = 20 * months;
        double internetBills = 15 * months;
        double otherBills = 0;

        for (int i = 1; i <= months; i++) {
            double electricityCurrentMonth = Double.parseDouble(scanner.nextLine());
            electricityBills += electricityCurrentMonth;

            double otherCurrentMonth = (electricityCurrentMonth + 35) * 1.2;
            otherBills += otherCurrentMonth;
        }

        double averageMonthlyBills = (electricityBills + waterBills + internetBills + otherBills) / months;

        System.out.printf("Electricity: %.2f lv%n", electricityBills);
        System.out.printf("Water: %.2f lv%n", waterBills);
        System.out.printf("Internet: %.2f lv%n", internetBills);
        System.out.printf("Other: %.2f lv%n", otherBills);
        System.out.printf("Average: %.2f lv%n", averageMonthlyBills);
    }
}
