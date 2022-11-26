package lecture07BAssociativeArraysExercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companyEmployees = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];

            companyEmployees.putIfAbsent(company, new ArrayList<>());

            if (!companyEmployees.get(company).contains(employeeId)) {
                companyEmployees.get(company).add(employeeId);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companyEmployees.entrySet()) {
            System.out.println(entry.getKey());

            for (String employee : entry.getValue()) {
                System.out.println("-- " + employee);
            }
        }
    }
}
