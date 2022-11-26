package lecture03ASetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());

            double total = 0;

            for (double grade : grades) {
                total += grade;
            }

            studentGrades.put(name, total / grades.size());
        }

        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            String student = entry.getKey();
            double averageGrade = entry.getValue();

            DecimalFormat df = new DecimalFormat("###.#########################################");

            System.out.printf("%s is graduated with %s%n", student, df.format(averageGrade));
        }
    }
}
