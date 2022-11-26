package lecture05AWhileLoopLab;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String student = scanner.nextLine();

        int year = 1;
        double sumGrades = 0;
        int counter = 0;

        while (year <= 12) {
            if (counter == 2) {
                break;
            }

            double grade = Double.parseDouble(scanner.nextLine());

            if (grade < 4) {
                counter++;
                continue;
            }

            sumGrades += grade;
            year++;
        }

        if (counter < 2) {
            System.out.printf("%s graduated. Average grade: %.2f%n", student, sumGrades / 12);
        } else {
            System.out.printf("%s has been excluded at %d grade%n", student, year);
        }
    }
}
