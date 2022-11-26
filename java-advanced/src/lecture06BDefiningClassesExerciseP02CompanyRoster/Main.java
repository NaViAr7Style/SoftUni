package lecture06BDefiningClassesExerciseP02CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");

            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String employeeDepartment = employeeData[3];

            Employee employee = null;

            switch (employeeData.length) {
                case 4:
                    employee = new Employee(name, salary, position, employeeDepartment);
                    break;
                case 5:
                    if (employeeData[4].contains("@")) {
                        String employeeEmail = employeeData[4];
                        employee = new Employee(name, salary, position, employeeDepartment, employeeEmail);
                    } else {
                        int employeeAge = Integer.parseInt(employeeData[4]);
                        employee = new Employee(name, salary, position, employeeDepartment, employeeAge);
                    }
                    break;
                case 6:
                    String email = employeeData[4];
                    int age = Integer.parseInt(employeeData[5]);
                    employee = new Employee(name, salary, position, employeeDepartment, email, age);
                    break;
            }

            boolean departmentExists = departments
                    .stream()
                    .anyMatch(department -> department.getName().equals(employeeDepartment));

            if (!departmentExists) {
                Department department = new Department(employeeDepartment);
                departments.add(department);
            }

            Department currentDepartment = departments
                    .stream()
                    .filter(dep -> dep.getName().equals(employeeDepartment))
                    .findFirst()
                    .get();

            currentDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = departments
                .stream()
                .max(Comparator.comparingDouble(Department::calculateAverageSalary))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees()
                .stream()
                .sorted((first, second) -> Double.compare(second.getSalary(), first.getSalary()))
                .forEach(System.out::println);
    }
}