package lecture05BWhileLoopExercise;

import java.util.Scanner;

public class P02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allowedPoorGrades = Integer.parseInt(scanner.nextLine());
        String problemTitle = scanner.nextLine();

        int poorGradeCounter = 0;
        int problemCounter = 0;
        int gradeSum = 0;
        String lastProblem = "";
        boolean isFailed = false;

        while (!problemTitle.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());

            if (grade <= 4) {
                poorGradeCounter++;
            }
            if (poorGradeCounter == allowedPoorGrades) {
                isFailed = true;
                break;
            }

            lastProblem = problemTitle;
            problemCounter++;
            gradeSum += grade;

            problemTitle = scanner.nextLine();
        }

        if (isFailed) {
            System.out.printf("You need a break, %d poor grades.%n", poorGradeCounter);
        } else {
            System.out.printf("Average score: %.2f%n", gradeSum * 1.0 / problemCounter);
            System.out.printf("Number of problems: %d%n", problemCounter);
            System.out.printf("Last problem: %s%n", lastProblem);
        }
    }
}
