package lecture06BNestedLoopsExercise;

import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int judges = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int counter = 0;
        double finalScore = 0;

        while (!input.equals("Finish")) {
            String presentation = input;
            double totalScore = 0;
            counter++;

            for (int i = 1; i <= judges; i++) {
                double currentGrade = Double.parseDouble(scanner.nextLine());
                totalScore += currentGrade;
            }
            double grade = totalScore / judges;
            finalScore += grade;
            System.out.printf("%s - %.2f.%n", presentation, grade);

            input = scanner.nextLine();
        }

        System.out.printf("Student's final assessment is %.2f.%n", finalScore / counter);
    }
}
