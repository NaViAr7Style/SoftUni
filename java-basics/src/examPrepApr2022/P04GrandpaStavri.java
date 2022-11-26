package examPrepApr2022;

import java.util.Scanner;

public class P04GrandpaStavri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double totalQuantity = 0;
        double totalQuality = 0;

        for (int i = 1; i <= n; i++) {
            double brandyQuantity = Double.parseDouble(scanner.nextLine());
            double brandyQuality = Double.parseDouble(scanner.nextLine());

            totalQuantity += brandyQuantity;
            totalQuality += brandyQuality * brandyQuantity;
        }

        double averageQuality = totalQuality / totalQuantity;

        System.out.printf("Liter: %.2f%n", totalQuantity);
        System.out.printf("Degrees: %.2f%n", averageQuality);

        if (averageQuality < 38) {
            System.out.println("Not good, you should baking!");
        } else if (averageQuality <= 42) {
            System.out.println("Super!");
        } else {
            System.out.println("Dilution with distilled water!");
        }
    }
}
