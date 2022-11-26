package lecture07BAssociativeArraysExercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> database = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String course = input.split(" : ")[0];
            String student = input.split(" : ")[1];

            database.putIfAbsent(course, new ArrayList<>());
            database.get(course).add(student);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : database.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            for (String student : entry.getValue()) {
                System.out.println("-- " + student);
            }
        }
    }
}
