package lecture03ASetsAndMapsAdvancedLab;

import java.util.*;

public class P05AverageStudentsGrades {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsBook = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String student = input[0];
            double grade = Double.parseDouble(input[1]);

            studentsBook.putIfAbsent(student, new ArrayList<>());
            studentsBook.get(student).add(grade);
        }

        for (var student : studentsBook.entrySet()) {
            System.out.printf("%s -> ", student.getKey());

            double averageGrade = 0;

            for (Double grade : student.getValue()) {
                System.out.printf("%.2f ", grade);
                averageGrade += grade;
            }

            averageGrade /= student.getValue().size();

            System.out.printf("(avg: %.2f)%n", averageGrade);
        }
    }
}