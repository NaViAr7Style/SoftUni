package lecture03CConditionalStatementsAdvancedAdditionalExercises;

import java.util.Scanner;

public class P02BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniorsCount = Integer.parseInt(scanner.nextLine());
        int seniorsCount = Integer.parseInt(scanner.nextLine());
        String raceType = scanner.nextLine();

        //Дефинираме си променлива, в която ще пазим сумата, която сме събрали от състезанието.
        double raisedMoney = 0;

        //Проверяваме какъв тип ще бъде трасето.
        switch (raceType) {
            case "trail":
                raisedMoney = juniorsCount * 5.50 + seniorsCount * 7.00;
                break;
            case "cross-country":
                raisedMoney = juniorsCount * 8.00 + seniorsCount * 9.50;
                if (juniorsCount + seniorsCount >= 50) {    //Правим проверка ако сме събрали повече от 50 души.
                    raisedMoney *= 0.75;                    //Ако са повече от 50, изваждаме 25% от събраната сума.
                }
                break;
            case "downhill":
                raisedMoney = juniorsCount * 12.25 + seniorsCount * 13.75;
                break;
            case "road":
                raisedMoney = juniorsCount * 20.00 + seniorsCount * 21.50;
                break;
        }

        System.out.printf("%.2f%n", raisedMoney * 0.95); //Изваждаме 5% от крайната сума за разходи.
    }
}
