package lecture01BFirstStepsInCodingExercise;

import java.util.Scanner;

public class P04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bookPages = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int daysPerBook = Integer.parseInt(scanner.nextLine());

        int hoursPerBook = bookPages / pagesPerHour;
        int hoursPerDay = hoursPerBook / daysPerBook;

        System.out.println(hoursPerDay);
    }
}
