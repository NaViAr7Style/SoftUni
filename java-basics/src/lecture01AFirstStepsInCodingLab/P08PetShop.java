package lecture01AFirstStepsInCodingLab;

import java.util.Scanner;

public class P08PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogFood = Integer.parseInt(scanner.nextLine());
        int catFood = Integer.parseInt(scanner.nextLine());

        double cost = dogFood * 2.5 + catFood * 4.0;

        System.out.println(cost + " lv.");
    }
}
