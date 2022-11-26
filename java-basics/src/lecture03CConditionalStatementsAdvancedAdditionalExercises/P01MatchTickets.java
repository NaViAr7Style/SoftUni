package lecture03CConditionalStatementsAdvancedAdditionalExercises;

import java.util.Scanner;

public class P01MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int headCount = Integer.parseInt(scanner.nextLine());

        //Дефинираме си променливи за разходи за транспорт и цена на билета.
        double transportExpenses = 0;
        double ticketPrice = 0;

        //Правим проверка за броя души и променяме разходите за транспорт спрямо тях.
        if (headCount < 5) {
            transportExpenses = budget * 0.75;
        } else if (headCount < 10) {
            transportExpenses = budget * 0.6;
        } else if (headCount < 25) {
            transportExpenses = budget * 0.5;
        } else if (headCount < 50) {
            transportExpenses = budget * 0.4;
        } else {
            transportExpenses = budget * 0.25;
        }

        //Променяме цената на билета спрямо категорията на билета.
        switch (category) {
            case "VIP":
                ticketPrice = 499.99;
                break;
            case "Normal":
                ticketPrice = 249.99;
                break;
        }

        //Пресмятаме на колко се равняват всички разходи.
        double totalExpenses = transportExpenses + ticketPrice * headCount;

        //Правим проверка дали бюджета ни покрива разходите.
        if (budget >= totalExpenses) {
            System.out.printf("Yes! You have %.2f leva left.%n", budget - totalExpenses);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.%n", totalExpenses - budget);
        }
    }
}
