package lecture06CObjectsAndClassesAdditionalExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01CompanyRoster {
    static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Department {
        private List<Employee> employees;

        public Department(List<Employee> employees) {
            this.employees = employees;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int n = Integer.parseInt(scanner.nextLine());
//
//        List<Employee> employeeList = new ArrayList<>();
//        List<Department> departmentList = new ArrayList<>();
//
//        for (int i = 1; i <= n; i++) {
//            String[] input = scanner.nextLine().split(" ");
//            String name = input[0];
//            double salary = Double.parseDouble(input[1]);
//            String position = input[2];
//            String department = input[3];
//
//            Employee employee = new Employee(name, salary, position, department);
//
//        }
    }
}
