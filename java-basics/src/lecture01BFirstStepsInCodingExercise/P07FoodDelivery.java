package lecture01BFirstStepsInCodingExercise;

import java.util.Scanner;

public class P07FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int vegetarianMenu = Integer.parseInt(scanner.nextLine());

        double chickenPrice = chickenMenu * 10.35;
        double fishPrice = fishMenu * 12.40;
        double vegetarianPrice = vegetarianMenu * 8.15;

        double menuPrice = chickenPrice + fishPrice + vegetarianPrice;
        double dessert = menuPrice * 0.20;
        double delivery = 2.50;

        double totalPrice = menuPrice + dessert + delivery;

        System.out.println(totalPrice);
    }
}
