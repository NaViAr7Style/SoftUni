package lecture02CConditionalStatementsAdditionalExercises;

import java.util.Scanner;

public class P07FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnoliasCount = Integer.parseInt(scanner.nextLine());
        int hyacinthsCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int cactiCount = Integer.parseInt(scanner.nextLine());
        double presentPrice = Double.parseDouble(scanner.nextLine());

        double orderRevenue = (magnoliasCount * 3.25 + hyacinthsCount * 4 + rosesCount * 3.5 + cactiCount * 8) * 0.95;

        if (orderRevenue >= presentPrice) {
            System.out.printf("She is left with %.0f leva.%n", Math.floor(orderRevenue - presentPrice));
        } else {
            System.out.printf("She will have to borrow %.0f leva.%n", Math.ceil(presentPrice - orderRevenue));
        }
    }
}
