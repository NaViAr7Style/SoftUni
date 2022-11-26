package lecture04CForLoopAdditionalExercises;

import java.util.Scanner;

public class P04Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = Integer.parseInt(scanner.nextLine());

        double averageGrade = 0;
        int poor = 0;
        int satisfactory = 0;
        int good = 0;
        int excellent = 0;

        for (int i = 1; i <= studentCount; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            averageGrade += grade;

            if (grade >= 5) {
                excellent++;
            } else if (grade >= 4) {
                good++;
            } else if (grade >= 3) {
                satisfactory++;
            } else {
                poor++;
            }
        }

        averageGrade /= studentCount;

        System.out.printf("Top students: %.2f%%%n", excellent * 100.0 / studentCount);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", good * 100.0 / studentCount);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", satisfactory * 100.0 / studentCount);
        System.out.printf("Fail: %.2f%%%n", poor * 100.0 / studentCount);
        System.out.printf("Average: %.2f%n", averageGrade);
    }
}
