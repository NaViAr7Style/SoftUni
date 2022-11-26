package lecture01BFirstStepsInCodingExercise;

import java.util.Scanner;

public class P08BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fee = Integer.parseInt(scanner.nextLine());

        double sneakers = fee * 0.6;
        double outfit = sneakers * 0.8;
        double ball = outfit / 4;
        double accessories = ball / 5;

        double basketballExpenses = fee + sneakers + outfit + ball + accessories;

        System.out.println(basketballExpenses);
    }
}
