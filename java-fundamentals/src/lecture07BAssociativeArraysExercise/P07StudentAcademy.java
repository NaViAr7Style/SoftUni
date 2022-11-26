package lecture07BAssociativeArraysExercise;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> gradeRegister = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            gradeRegister.putIfAbsent(student, new ArrayList<>());
            gradeRegister.get(student).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : gradeRegister.entrySet()) {
            double averageGrade = 0;
            for (double grade : entry.getValue()) {
                averageGrade += grade;
            }
            averageGrade /= entry.getValue().size();

            if (averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }
        }
    }
}
