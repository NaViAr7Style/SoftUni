package lecture03BConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class P02SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int temperature = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();
        String outfit = "";
        String shoes = "";

        switch (timeOfDay) {
            case "Morning":
                if (10 <= temperature && temperature <= 18) {
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                } else if (18 < temperature && temperature <= 24) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                } else if (temperature >= 25) {
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                }
                break;
            case "Afternoon":
                if (10 <= temperature && temperature <= 18) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                } else if (18 < temperature && temperature <= 24) {
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                } else if (temperature >= 25) {
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                }
                break;
            case "Evening":
                if (temperature >= 10) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                }
                break;
        }

        System.out.printf("It's %d degrees, get your %s and %s.%n", temperature, outfit, shoes);
    }
}
