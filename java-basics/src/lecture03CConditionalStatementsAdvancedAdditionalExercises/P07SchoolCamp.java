package lecture03CConditionalStatementsAdvancedAdditionalExercises;

import java.util.Scanner;

public class P07SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int nightsCount = Integer.parseInt(scanner.nextLine());

        double pricePerNight = 0;
        String sport = "";

        switch (groupType) {
            case "boys":
                switch (season) {
                    case "Spring":
                        sport = "Tennis";
                        pricePerNight = 7.2;
                        break;
                    case "Summer":
                        sport = "Football";
                        pricePerNight = 15;
                        break;
                    case "Winter":
                        sport = "Judo";
                        pricePerNight = 9.6;
                        break;
                }
                break;
            case "girls":
                switch (season) {
                    case "Spring":
                        sport = "Athletics";
                        pricePerNight = 7.2;
                        break;
                    case "Summer":
                        sport = "Volleyball";
                        pricePerNight = 15;
                        break;
                    case "Winter":
                        sport = "Gymnastics";
                        pricePerNight = 9.6;
                        break;
                }
                break;
            case "mixed":
                switch (season) {
                    case "Spring":
                        sport = "Cycling";
                        pricePerNight = 9.5;
                        break;
                    case "Summer":
                        sport = "Swimming";
                        pricePerNight = 20;
                        break;
                    case "Winter":
                        sport = "Ski";
                        pricePerNight = 10;
                        break;
                }
                break;
        }

        double totalCost = studentsCount * nightsCount * pricePerNight;

        if (studentsCount < 20) {
            if (studentsCount >= 10) {
                totalCost *=0.95;
            }
        } else if (studentsCount < 50) {
            totalCost *= 0.85;
        } else {
            totalCost *= 0.5;
        }

        System.out.printf("%s %.2f lv.%n", sport, totalCost);
    }
}
