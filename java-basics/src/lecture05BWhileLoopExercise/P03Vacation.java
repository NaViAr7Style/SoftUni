package lecture05BWhileLoopExercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripCost = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int days = 0;
        int counter = 0;
        double savedMoney = availableMoney;
        boolean cantSaveMoney = false;

        while (savedMoney < tripCost) {
            String action = scanner.nextLine();
            double amount = Double.parseDouble(scanner.nextLine());
            days++;

            switch (action) {
                case "spend":
                    savedMoney -= amount;
                    counter++;

                    if (savedMoney < 0) {
                        savedMoney = 0;
                    }
                    break;
                case "save":
                    savedMoney += amount;
                    counter = 0;
                    break;
            }

            if (counter == 5) {
                cantSaveMoney = true;
                break;
            }
        }

        if (cantSaveMoney) {
            System.out.println("You can't save the money.");
            System.out.println(days);
        } else {
            System.out.printf("You saved the money for %d days.%n", days);
        }
    }
}
